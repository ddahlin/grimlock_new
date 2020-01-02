package GrimlockInitialisation.Listeners;

import GrimlockFramework.Utils.SlackSuiteStatus;
import GrimlockInitialisation.CoreInitialisation.GrimlockApi;
import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class SuiteListener implements ISuiteListener {
    public SlackSuiteStatus slackSuiteStatus = new SlackSuiteStatus();
    private final Logger logger = Logger.getLogger(TestListener.class);

    @Override
    public void onStart(ISuite iSuite) {
logger.info(iSuite.getXmlSuite().getParameter("test_name"));
        slackSuiteStatus.postSuiteStatus(iSuite.getXmlSuite().getParameter("test_name"),"Running");
       if(Grimlock == null)
           Grimlock =  new GrimlockApi();
    }


    @Override
    public void onFinish(ISuite iSuite) {
        slackSuiteStatus.postSuiteStatus(iSuite.getXmlSuite().getParameter("test_name"),"Completed");
        if (Grimlock.eventService() != null&&Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("charles")) {
            Grimlock.eventService().networkSniffer.stopNetworkSniffer();
            try {
                Runtime.getRuntime().exec("killall Charles");

            } catch (Exception e) {

            }
        }
    }

}
