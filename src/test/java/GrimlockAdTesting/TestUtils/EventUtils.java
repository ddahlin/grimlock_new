package GrimlockAdTesting.TestUtils;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public  class EventUtils {

    public static final Logger logger = Logger.getLogger(EventUtils.class);

    public static void multiTrack(String eventName, int times) {

        for (int iterator = 0; iterator < times; iterator++)
            Grimlock.eventService().trackEvents(eventName);
    }

    public static String getEventName(String eventName, String value, String[] pixels) {
        for (String neededTofound : pixels)
            if (value.contains(neededTofound))
                if (eventName.isEmpty())
                    eventName = neededTofound;
                else
                    Grimlock.eventService().found.trackEvents(neededTofound);
        return eventName;
    }

    public static String extractTremorEventECFromJson(Object jsonObject) {
        String eventName = "";
        try {
            if (((JSONObject) jsonObject).get("method").toString().toLowerCase().equals("get")) {
                String queryParam = ((JSONObject) jsonObject).get("query").toString();
                eventName = getEventName(eventName, queryParam, RMLTrackingPixels.PixelsFromQuery);
            }

        } catch (Exception e) {
        }
        if (!eventName.isEmpty())
            logger.info(eventName);

        return eventName;

    }

    public static void checkPixels (Set set){
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Integer.parseInt((mentry.getValue().toString()));
            multiTrack(mentry.getKey().toString(), Integer.parseInt((mentry.getValue().toString())));
        }

    }

}
