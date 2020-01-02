import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.SecondaryVideo;
import GrimlockEventHandler.NetworkSniffer.HarParsers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;


public class SecVideo {
    public SecondaryVideo secondaryVideo;
    @BeforeMethod(groups = "fyber6")
    public void initPxp() throws Exception {
        Grimlock.eventService().setParseEventFunction(HarParsers::extractRaptorEventName,HarParsers::getUnixTimeFromHar);

    }

    @Test(groups = "fyber6")
    public void secVideoTest() throws Exception{
        secondaryVideo = new SecondaryVideo();
        secondaryVideo.applicationBuilder.setUpAdInApp(secondaryVideo.tremorAdTypeVastXml.secondaryUrl);
        secondaryVideo.clickOnBug();
        secondaryVideo.clickOnPlaySecondaryVideo();
        secondaryVideo.clickOnPauseSecondaryVideo();
        secondaryVideo.clickOnCloseSecondaryVideo();
    }

    @Test(groups = "fyber6")
    public void secVideoTest1() throws Exception{
        secondaryVideo = new SecondaryVideo();
        secondaryVideo.applicationBuilder.setUpAdInApp(secondaryVideo.tremorAdTypeVastXml.secondaryUrl);
        secondaryVideo.clickOnBug();
        secondaryVideo.clickOnPlaySecondaryVideo();
        Thread.sleep(20000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_SECONDARY_VIDEO_100.toString());
        secondaryVideo.clickOnCloseSecondaryVideo();
    }
}
