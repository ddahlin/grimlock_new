import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class TestPxpStandardContUrl {
    public Pxp pxp;
//    int playbackRate = 5;
    @BeforeMethod(groups = "pxp")
    public void initPxp() throws Exception {
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardContUrl);
    }

    @Test(groups = "pxp")
    public void pxpDoNotClickToContinue() throws Exception{
        Thread.sleep(35000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_PREROLL_100.toString());
        Grimlock.eventService().validate();
    }

    @Test(groups = "pxp1")
    public void pxpClickToContinueWaitUntilEnd() throws Exception{

        pxp.clickOnClickToContinue();
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_0.toString());
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
        Grimlock.eventService().validate();
    }

    @Test(groups = "pxp1")
    public void pxpClickToContinueCloseButton() throws Exception{

        pxp.clickOnClickToContinue();
        pxp.clickOnCloseButton();
        Grimlock.eventService().validate();
    }
}
