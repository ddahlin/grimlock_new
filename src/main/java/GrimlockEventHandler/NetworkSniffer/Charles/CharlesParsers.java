package GrimlockEventHandler.NetworkSniffer.Charles;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CharlesParsers {
    static JSONParser jsonParser = new JSONParser();

    public static String extractPixelName(Object jsonObject){
        String event = "";
        try{
            if (((JSONObject)jsonObject).get("method").toString().toLowerCase().equals("get")) {
                String queryParam = ((JSONObject) jsonObject).get("query").toString();
                String[] params = queryParam.split("&");
                for (String curParam:params) {
                    String[] p = curParam.split("=");
                    if (p[0].equals("event")) event = p[1];
                }
            }
        }catch (Exception e){}
        return event;
    }
    public static String extractNYPixelName(Object jsonObject){
        String event = "";
        try{
            if (((JSONObject)jsonObject).get("method").toString().toLowerCase().equals("get")) {
                String queryParam = ((JSONObject) jsonObject).get("query").toString();
                String[] params = queryParam.split("&");
                for (String curParam:params) {
                    String[] p = curParam.split("=");
                    if (p[0].equals("param1")) event = p[1];
                }
            }
        }catch (Exception e){}
        return event;
    }

    public static String extractEventName(Object jsonObject) {
        String eventName = "";
        try {
            if (((JSONObject) jsonObject).get("method").toString().toLowerCase().equals("post")) {
                String bodyText = getRequestBodyText(jsonObject);
                eventName = extractJsonAsStringFromJsonObject(createJsonFromString(bodyText), "name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventName;
    }

    public static String getRequestBodyText(Object jsonObj) {
        String val = "";
        try {
            val = JsonPath.read(jsonObj, "$.request.body.text");
        } catch (PathNotFoundException ex) {

        }
        return val;
    }

    private String getRequestBodyText(JSONArray jsonArray, int i) throws Exception {
        String val = "";
        try {
            val = JsonPath.read(jsonArray.get(i), "$.request.body.text");
        } catch (PathNotFoundException ex) {

        }
        return val;
    }


    public static long getUnixTimeFromJson(Object jsonObject) {
        JSONObject times = extractJsonObjectByPathName((JSONObject) jsonObject, "times");
        return getDate(times, "start").getTime();
    }

    private JSONObject object2JsonObject(Object jsonArray) throws Exception {
        return (JSONObject) jsonArray;
    }

    private static JSONObject createJsonFromString(String json) throws ParseException {
        return (JSONObject) jsonParser.parse(json);
    }

    private static JSONObject extractJsonObjectByPathName(JSONObject jsonObject, String name) {
        return (JSONObject) jsonObject.get(name);
    }

    private static String extractJsonAsStringFromJsonObject(JSONObject jsonObject, String name) {
        return jsonObject.get(name).toString();
    }

    private static Date getDate(JSONObject jsonObject, String name) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").parse(jsonObject.get(name).toString());

        } catch (Exception e) {}
        return new Date();
    }
}
