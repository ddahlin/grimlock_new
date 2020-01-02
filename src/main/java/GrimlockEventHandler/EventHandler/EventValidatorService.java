package GrimlockEventHandler.EventHandler;

import GrimlockEnums.GrimlockEnums;
import GrimlockEventHandler.NetworkSniffer.Charles.CharlesParsers;
import GrimlockEventHandler.NetworkSniffer.HarParsers;
import GrimlockEventHandler.NetworkSniffer.NetworkSniffer;
import javafx.util.Pair;
import net.lightbody.bmp.core.har.HarEntry;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import java.io.FileReader;
import java.util.*;
import java.util.function.Function;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;


public class EventValidatorService {
    static Comparator<EventObject> eventObjectComparator = ((EventObject o1, EventObject o2) -> (int) (o1.getUnixTime() - o2.getUnixTime()));
    private static final int DEFAULT_EVENT_TOLERANCE = 3000;
    public Map<String, ArrayList<EventObject>> eventMaps;
    public EventValidatorService found;
    public NetworkSniffer networkSniffer;
    private Function<Object, String> parseEventFunction;
    private Function<Object, Long> parseTimeFunction;
    private String pathToNetworkSnifferRecord = "/tmp/session.chlsj";

    /**
     * Constructor for Event Service
     *
     * @param networkSniffer getting network sniffer interface
     */
    public EventValidatorService(NetworkSniffer networkSniffer) {
        eventMaps = new HashMap<>();
        if (networkSniffer != null) {
            this.networkSniffer = networkSniffer;
            if (Grimlock.params() != null) {
                if (!Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp")) {
                    this.networkSniffer.stopNetworkSniffer();
                    this.networkSniffer.startNetworkSniffer();
                }
            }
        }
    }

    /**
     * add event to track
     *
     * @param eventName //Event String to Track
     */
    public void trackEvents(String eventName) {
        trackEvents(eventName, GrimlockEnums.DEFAULT_EVENT_TOLERANCE);
    }

    /**
     * add event to track
     *
     * @param eventName Event String to Track
     * @param tolerance Tolerance in ms
     */
    public void trackEvents(String eventName, int tolerance) {
        createValueForKeyIfNotExist(eventName, (System.currentTimeMillis()), tolerance);
    }

    /**
     * add event to track
     *
     * @param eventName Event String to Track
     * @param unixTime  Time in UnixTime format
     * @param tolerance Tolerance in ms
     */
    public void trackEvents(String eventName, long unixTime, int tolerance) {
        createValueForKeyIfNotExist(eventName, unixTime, tolerance);
    }

    /**
     * get the map
     *
     * @return return the event map
     */
    public Map<String, ArrayList<EventObject>> getEventMaps() {
        return eventMaps;
    }

    public void setParseEventFunction(Function<Object, String> eventNameFunc, Function<Object, Long> eventTimeFunc) {
        this.parseEventFunction = eventNameFunc != null ? eventNameFunc : HarParsers::extractRaptorEventName;
        this.parseTimeFunction = eventTimeFunc != null ? eventTimeFunc : HarParsers::getUnixTimeFromHar;
    }

    /**
     * validate with json file
     * current - Charles recording
     *
     * @throws Exception throws Exception
     */
    public void validate() {
        if (this.networkSniffer == null) return;
        Pair<String, String> compareResult = new Pair<>("", "");
        try {
            if (!Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp"))
                pathToNetworkSnifferRecord = this.networkSniffer.downloadRecording();
            if(parseEventFunction==null||parseTimeFunction==null)
                setParseEventFunction(HarParsers::extractQuaryName,HarParsers::getUnixTimeFromHar);
            compareResult = CompareEventCount(ParseEventsObjectFromRecored(this.parseEventFunction, this.parseTimeFunction, eventMaps, pathToNetworkSnifferRecord));
            eventMaps.clear();
            if (!Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp"))
                networkSniffer.startRecording();
            Assert.assertEquals(compareResult.getValue(), compareResult.getKey(), "\n\nValidation Failed. Event Compare Not Equals\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void createValueForKeyIfNotExist(String eventName, long unixTime, int tolerance) {
        ArrayList<EventObject> timestampArray = eventMaps.get(eventName);
        if (timestampArray == null) {
            eventMaps.put(eventName, new ArrayList<>());
            timestampArray = eventMaps.get(eventName);
        }
        timestampArray.add(new EventObject(eventName, unixTime, tolerance));
        timestampArray.sort(eventObjectComparator);
    }

    private Pair CompareEventCount(Map<String, ArrayList<EventObject>> result) {
        StringBuilder expectedString = new StringBuilder();
        StringBuilder actualString = new StringBuilder();
        int counter = 0;
        for (String eventName : eventMaps.keySet()) {
            counter++;
            Pair<Integer, Integer> res = compareEventObjectArray(eventMaps.get(eventName), result.get(eventName));
            if (res.getValue() != res.getKey()) {
                expectedString.append(eventName).append(" - ").append("" + res.getKey());
                actualString.append(eventName).append(" - ").append("" + res.getValue());
                if (counter < eventMaps.size()) {
                    expectedString.append(", ");
                    actualString.append(", ");
                }
            }
        }
        return new Pair(expectedString.toString(), actualString.toString());
    }

    private Pair compareEventObjectArray(ArrayList<EventObject> expectedArray, ArrayList<EventObject> jsonArray)  {
        if (expectedArray == null)
            return new Pair(0, jsonArray.size());
        if (jsonArray == null)
            return new Pair(expectedArray.size(), 0);

        return new Pair(expectedArray.size(), jsonArray.size());
    }


    JSONParser jsonParser = new JSONParser();

    private Map<String, ArrayList<EventObject>> ParseEventsObjectFromRecored(Function<Object, String> parseEventNameFunction, Function<Object, Long> parseEventTimeFunction, Map<String, ArrayList<EventObject>> events, String pathToFile) {
       found = new EventValidatorService(null);
        try {
            if (Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp"))
//                compareHarFile(Grimlock.proxy().getHar(), eventMaps);
            {
                List<HarEntry> entries = Grimlock.proxy().getHar().getLog().getEntries();
                if(entries.isEmpty()) {
                    return found.getEventMaps();
                }
                if ((Grimlock).params().Website != null) {
                    if (Grimlock.params().getWebsite("browser").toLowerCase().contains("safari")) {
                        List<HarEntry> temp = new ArrayList<>();
                        for (HarEntry entry : entries) {
                            if (entry.getRequest().getHeaders().toString().toLowerCase().contains("safari"))
                                temp.add(entry);
                        }
                        entries = temp;
                    }
                }
                for (HarEntry entry : entries) {
                    String eventName = parseEventNameFunction.apply(entry);
                    if (isEventNameNotFound(eventName))
                        continue;
                    long unixTime = parseEventTimeFunction.apply(entry);
                    if (events.containsKey(eventName))
                        found.trackEvents(eventName, unixTime, 0);
                }
            } else {
                JSONArray jsonArray = object2JsonArray(json2Object(pathToFile));
                for (int i = 0; i < jsonArray.size(); i++) {

                    String eventName = parseEventNameFunction.apply(jsonArray.get(i));
                    if (isEventNameNotFound(eventName))
                        continue;
                    long unixTime = parseEventTimeFunction.apply(jsonArray.get(i));
                    if (events.containsKey(eventName))
                        found.trackEvents(eventName, unixTime, 0);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            Assert.assertTrue(false, e.getMessage());
        }
        System.out.println(found.toString());
        return found.getEventMaps();
    }

    private boolean isEventNameNotFound(String eventName) {
        return eventName.equals("") || eventName == null;
    }


    private JSONArray object2JsonArray(Object object) throws Exception {
        return (JSONArray) object;
    }

    private Object json2Object(String path2file) throws Exception {
        return jsonParser.parse(new FileReader(path2file));
    }
}
