import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockAdTesting.TestUtils.EventEnums.MEDIA_PROGRESS_LONGFORM_GREEN_100;
import static GrimlockAdTesting.TestUtils.EventEnums.MEDIA_PROGRESS_LONGFORM_RED_100;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class PxpAgeGateNonCont3Url {
    public Pxp pxp;

    @BeforeMethod(groups = "fyber2")
    public void initPxp() throws Exception {

    }

    @Test(groups = "fyber1")
    public void pxpClickOnAgeGateNo() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
    }

    @Test(groups = "fyber1")
    public void pxpClickOnAgeGateNoNoClearCache() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
    }

    @Test(groups = "fyber")
    public void pxpClickOnAgeGateNoNoClearCacheWaitForClickToContinue() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnClickToContinue();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_GREEN_100.toString());
    }

    @Test(groups = "fyber1")
    public void pxpClickOnAgeGateYes() throws Exception{
//        pxp = new Pxp();
//        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
    }

    @Test(groups = "fyber1")
    public void pxpClickOnAgeGateYesNoClearCache() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
    }

    @Test(groups = "fyber2")
    public void pxpClickOnAgeGateYesNoClearCacheWaitForClickToContinue() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont3Url);
        pxp.clickOnClickToContinue();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_RED_100.toString());
    }


}
