import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class PxpStandardNonContUrl {
    public Pxp pxp;

    @BeforeMethod(groups = "pxp")
    public void initPxp() throws Exception {

    }

    @Test(groups = "pxp")
    public void pxpClickOnClickToContinue() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnClickToContinue();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnBug() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnOldBug();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnClickToContinueNoClearCache() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnClickToContinue();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnOldBug();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnBugNoClearCacheClickOnClickToContinue() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnOldBug();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnClickToContinue();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

    @Test(groups = "pxp")
    public void pxpClickOnClickToContinueNoClearCacheClickToContinue() throws Exception{
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnClickToContinue();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxpStandardNonContUrl);
        pxp.clickOnClickToContinue();
        Thread.sleep(130000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

}
