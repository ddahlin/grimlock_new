import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class PxpStandardContUrl {
    public Pxp pxp;
//    int playbackRate = 5;
    @BeforeMethod(groups = "fyber")
    public void initPxp() throws Exception {

    }

    @Test(groups = "fyber")
    public void pxpDoNotClickToContinue() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardContUrl);
        Thread.sleep(35000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_PREROLL_100.toString());
    }
//    @Test(groups = "pxp")
//    public void pxpDoNotClickToContinue() throws Exception{
//        pxp = new Pxp();
//        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardContUrl);
//        Thread.sleep(35000);
//        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_PREROLL_100.toString());
//    }

    @Test(groups = "pxp")
    public void pxpClickToContinueWaitUntilEnd() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardContUrl);
        pxp.clickOnClickToContinue();
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_0.toString());
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

//    @Test(groups = "pxp")
//    public void pxpClickToContinueWaitUntilEnd() throws Exception{
//
////        Thread.sleep(5000);
////
////        JavascriptExecutor js = (JavascriptExecutor) Grimlock.grimlockDriver.getDriverFramework();
////        Object devicePixelObj = js.executeScript("document.getElementsByClassName(\"jw-video jw-reset\")[0].playbackRate = " + playbackRate);
//        pxp.clickOnClickToContinue();
//        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_0.toString());
////        Thread.sleep(130000 / playbackRate +2000);
//        Thread.sleep(130000);
//        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
//        Grimlock.eventService().validate();
//
//    }

    @Test(groups = "pxp")
    public void pxpClickToContinueCloseButton() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardContUrl);
        pxp.clickOnClickToContinue();
        pxp.clickOnCloseButton();
    }
}
