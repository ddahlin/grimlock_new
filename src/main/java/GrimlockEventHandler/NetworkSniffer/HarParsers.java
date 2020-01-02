package GrimlockEventHandler.NetworkSniffer;

import GrimlockFramework.Utils.TrackingPixels;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarNameValuePair;
import org.apache.log4j.Logger;

import java.util.List;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class HarParsers {
    public static final Logger logger = Logger.getLogger(HarParsers.class);

    public static String extractQuaryName(Object entry) {
        String eventName = "";
        try {
            List<HarNameValuePair> inputParams = ((HarEntry) entry).getRequest().getQueryString();
            String temp;
            for (HarNameValuePair param : inputParams) {
                temp = param.getName()+"="+param.getValue()+"&";
                eventName = getEventName(eventName, temp, TrackingPixels.PixelsFromQuery);
            }

        } catch (Exception e) {
            eventName = "";
        }
        if (!eventName.isEmpty())
            logger.info(eventName);
        return eventName;
    }

    public static String extractRaptorEventName(Object entry){
        String result ="";
        try{String[] eventName = ((HarEntry)entry).getRequest().getPostData().getText().split("\"name\":\"");
            result = eventName[1];
            result = result.substring(0,result.length() - 2);
        }catch (Exception e){
            result ="";
        }
        return result;
    }
    public static long getUnixTimeFromHar(Object entry){
        long unixtime = ((HarEntry)entry).getStartedDateTime().getTime();
        return unixtime;
    }
    public static String getEventName(String eventName, String value, String [] pixels) {
        for (String neededTofound : pixels)
            if (value.contains(neededTofound))
                if (eventName.isEmpty())
                    eventName = neededTofound;
                else
                    Grimlock.eventService().found.trackEvents(neededTofound);
        return eventName;
    }
}
