package GrimlockAdTesting.TestUtils;


import GrimlockInitialisation.InitalisationUtils.networkUtils;

import java.net.URLEncoder;


public class RaptorWrapper {

    public  String vastInspectorPage = "https://preview.tremorvideodsp.com/";
    public static final String Raptor   = "./src/main/resources/Logs/RaptorLogs.txt";

    private  final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RaptorWrapper.class);

    public String wrapperVastXmlWithRaptorWrapper(String vastTagUrl, String sessionId) {
        String replacer = getReplacer(vastTagUrl, sessionId);
        return getFinalUrl(replacer);
    }

    public String getReplacer(String vastTagUrl, String sessionId) {
        return "https://raptor.tremorvideodsp.com/ws/rml/replacer?vastUri=" + vastTagUrl + "&addTVEvents=true" + "&sessionId=" + sessionId;
    }


    public String getFinalUrl(String replacer) {
        try {
            return vastInspectorPage + getProperties() + URLEncoder.encode(replacer, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getProperties() {
        return "index.html?#/desktop/default/jwplayer/basic?playerOptions%5Bautostart%5D=true&playerOptions%5Baspectratio%5D=16%3A9&playerOptions%5Badvertising%5D%5Bclient%5D=vast&playerOptions%5Badvertising%5D%5Badmessage%5D=Ad%20%E2%80%94%20xxs%20left&playerOptions%5Badvertising%5D%5Bautoplayadsmuted%5D=true&playerOptions%5Badvertising%5D%5Btag%5D=https%3A%2F%2Fs.tremorvideodsp.com%2Fm%2F2017%2F09%2FSkZvFXP9Z%2Fvast3.xml&playerOptions%5Bfile%5D=https%3A%2F%2Fwww.apple.com%2Fmedia%2Fus%2Fwatch%2F2015%2Fa718f271_b19c_47d8_928d_d108fc5d702a%2Ftour%2Fdesign%2Fwatch-design-cc-us-20140909_1280x720h.mp4&playerOptions%5Bid%5D=tesgreenayted3&adTagUri=";
    }


    public  void downloadAndSave(String sessionId) {
        try {
            logger.info("Fetching logs using : https://raptor.tremorvideodsp.com/ws/logger/pixels/" + sessionId
                    + ".json");
            networkUtils.getURLContent("https://raptor.tremorvideodsp.com/ws/logger/pixels/" + sessionId + ".json",
                    Raptor);
        } catch (Exception e) {
            logger.info("Error while fetching logs");
        }

    }


}

