package GrimlockEventHandler.NetworkSniffer.Charles;

import GrimlockEventHandler.NetworkSniffer.NetworkSniffer;
import org.apache.log4j.Logger;

import java.net.InetAddress;

/**
 * network recording for local testing-
 * Its can use for getting all event and pixel that fire from ad.
 */

public class CharlesRecording implements NetworkSniffer {
    private String startCharlesWithConfingFile = "Charles -headless -config ./src/main/java/GrimlockEventHandler/NetworkSniffer/Charles/charles.config &";
    private String defaultPort = "8888";
    private String prefixLocalIpAddress = "http://";
    private String curl = "curl";
    private String recordParams = "-v -x";
    private String downloadParams = "-o /tmp/session.chls -x";
    private String startRecording = "http://control.charles/recording/start";
    private String downloadRecording = "http://control.charles/session/download";
    private String stopRecording = "http://control.charles/recording/stop";
    private String convertToJson = "Charles convert /tmp/session.chls /tmp/session.chlsj";
    private final Logger logger = Logger.getLogger(CharlesRecording.class);
    public CharlesRecording() {
    }
    public void startNetworkSniffer() {
        try {
            Runtime.getRuntime().exec("rm -rf /tmp/session.chlsj /tmp/session.chls");
            Process killCharles = Runtime.getRuntime().exec("killall Charles");
            killCharles.waitFor();
//            Thread.sleep(3000);
            Process charles = Runtime.getRuntime().exec(startCharlesWithConfingFile);
            int attempts = 3;
            while (attempts > 0) {
                int exitCode = 0;
                try {
                    exitCode = charles.exitValue();
                    logger.info("EXIT CODE: " + exitCode);
                } catch (IllegalThreadStateException e) {
                    Thread.sleep(1000);
                    attempts--;
                }
                if (attempts > 0 && exitCode > 0)
                    throw new Exception("Charles failed to load");
            }
        } catch (Exception e) {
            logger.error("Charles is not installed - Track events won't be tested.");
            e.printStackTrace();
        }
    }

    public void startRecording() {
        try {
            Process deleteCharles = Runtime.getRuntime().exec("rm -rf /tmp/session.chlsj /tmp/session.chls");
            deleteCharles.waitFor();

            Process startRecored = Runtime.getRuntime().exec(getStartRecording());
            startRecored.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopNetworkSniffer() {
        try {
            Process stop = Runtime.getRuntime().exec(getStopRecording());
            stop.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String downloadRecording() {
        try {

            Process save = Runtime.getRuntime().exec(getDownloadRecording());
            save.waitFor();
            convertToJson();
            stopNetworkSniffer();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return downloadParams;
    }

    private void convertToJson() {
        try {
            Process convert = Runtime.getRuntime().exec(convertToJson);
            convert.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * build the command for startNetworkSniffer the record
     *
     * @return return us the final command
     * @throws Exception any network exception
     */
    private String getStartRecording() throws Exception {
        return curl + " " + recordParams + " " + prefixLocalIpAddress + getLocalIpAddress() + ":" + defaultPort + " " + startRecording;
    }

    /**
     * build the command for stopNetworkSniffer the record
     *
     * @return return us the final command
     * @throws Exception any network exception
     */
    private String getStopRecording() throws Exception {
        return curl + " " + recordParams + " " + prefixLocalIpAddress + getLocalIpAddress() + ":" + defaultPort + " " + stopRecording;
    }

    /**
     * build the command for download the record
     *
     * @return return the final command
     * @throws Exception any network exception
     */
    private String getDownloadRecording() throws Exception {
        return curl + " " + downloadParams + " " + prefixLocalIpAddress + getLocalIpAddress() + ":" + defaultPort + " " + downloadRecording;
    }

    /**
     * @return return us the command for convert to JSON.
     */
    private String getConvertToJson() {
        return convertToJson;
    }

    /**
     * this function will extract the local ip address by using java.net.InetAddress lib.
     *
     * @return the local ip address
     * @throws Exception any network exception
     */
    private String getLocalIpAddress() throws Exception {
        return InetAddress.getLocalHost().getHostAddress();
    }

}
