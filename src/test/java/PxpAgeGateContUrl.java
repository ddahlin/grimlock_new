import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class PxpAgeGateContUrl {

    public Pxp pxp;

    @BeforeMethod(groups = "fyber1")
    public void initPxp() throws Exception {

    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateNo() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        Thread.sleep(20000);
        pxp.clickOnAreYou18No();
        Thread.sleep(5000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_PREROLL_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateNoClickOnBug() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateNoNoClearCache() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateNoNoClearCacheClickOnBug() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        Thread.sleep(25000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_PREROLL_100.toString());
    }

    @Test(groups = "fyber1")
    public void pxpClickOnAgeGateYes() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        Thread.sleep(20000);
        pxp.clickOnAreYou18Yes();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_RED_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateYesClickOnBug() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateYesNoClearCache() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_RED_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateYesNoClearCacheWaitForClickToContinue() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateContUrl);
        pxp.clickOnClickToContinue();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_RED_100.toString());
    }
}
