import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PxpAgeGateCont2Url {
    public Pxp pxp;

    @BeforeMethod(groups = "PxpAgeGateCont2Url")
    public void initPxp() throws Exception {
        System.out.println("");
    }

    @Test(groups = "PxpAgeGateCont2Url")
    public void pxpClickOnAgeGateNo() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
    }


    @Test(groups = "PxpAgeGateCont2Url1")
    public void pxpClickOnAgeGateNoClickClose() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18No();
        Thread.sleep(20000);
        pxp.clickOnCloseButton();
    }

    @Test(groups = "PxpAgeGateCont2Url1")
    public void pxpClickOnAgeGateYes() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
    }

    @Test(groups = "PxpAgeGateCont2Url1")
    public void pxpClickOnAgeGateYesClickClose() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpAgeGateCont2Url);
        pxp.clickOnOldBug();
        pxp.clickOnAreYou18Yes();
        Thread.sleep(20000);
        pxp.clickOnCloseButton();
    }
}
