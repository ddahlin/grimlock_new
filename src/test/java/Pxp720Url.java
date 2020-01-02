import GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType.Pxp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class Pxp720Url {
    public Pxp pxp;

    @BeforeMethod(groups = "pxp1")
    public void initPxp() throws Exception {
        pxp = new Pxp();
        pxp.applicationBuilder.setUpAdInApp(pxp.tremorAdTypeVastXml.pxp720Url);
    }

    @Test(groups = "pxp1")
    public void pxpClickOnClickToContinue() throws Exception{
        pxp.clickOnClickToContinue();
        Thread.sleep(15000);
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

    @Test(groups = "pxp1")
    public void pxpClickOnBug() throws Exception{
        pxp.clickOnBug();
        Thread.sleep(30000);
        Grimlock.eventService().trackEvents(INTERACT_BUG_CLICK.toString());

        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

    @Test(groups = "pxp1")
    public void pxpClickOnBugTwice() throws Exception{
        pxp.clickOnBug();
        Thread.sleep(4000);
        pxp.clickOnBug();
        Thread.sleep(20000);
        Grimlock.eventService().trackEvents(INTERACT_BUG_CLICK.toString());
        Grimlock.eventService().trackEvents(CLICK_BUG.toString());
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }

    @Test(groups = "pxp1")
    public void pxpClickOnClickToContinueClickClose() throws Exception{
        pxp.clickOnClickToContinue();
        Thread.sleep(15000);
        pxp.clickOnCloseButton();
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_LONGFORM_100.toString());
    }
}
