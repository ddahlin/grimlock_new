import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class PxpAgeGateNonCont2Url {
    public Pxp pxp;

    @BeforeMethod(groups = "pxp")
    public void initPxp() throws Exception {
//        pxp = new Pxp();
//        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont2Url);
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateNo() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
        Grimlock.eventService().trackEvents(INTERACT_AGE_GATE_FAIL_CLICK.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateYes() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateYesWaitUntilEnd() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_RED_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateNoWaitUntilEnd() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
        Thread.sleep(15000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_PREROLL_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnAgeGateYesClickCloseButton() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateNonCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
        Thread.sleep(15000);
        pxp.clickOnCloseButton();
    }
}
