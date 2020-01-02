package GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import GrimlockAdTesting.TremorVideoAdType.VastGeneralCommands;
import GrimlockFramework.DriverCommands.GrimlockDriver;
import GrimlockFramework.DriverCommands.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class Pxp extends VastGeneralCommands {
    private static final Logger logger = Logger.getLogger(Pxp.class);
    public ApplicationBuilder applicationBuilder;

    public Pxp() {
        applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());

    }
    public void clickOnClickToContinue() throws Exception {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.PXP_CLICKTOCONTINUE_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,30000);
        logger.info("Click On Click To Continue ");
        Grimlock.eventService().trackEvents(INTERACT_CLICK_TO_CONTINUE_CLICK.toString());
    }

    public void clickOnAreYou18Yes() throws Exception {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.PXP_AGEGATEYES_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,10000);
        logger.info("Click On Yes button ");
        Grimlock.eventService().trackEvents(INTERACT_AGE_GATE_PASS_CLICK.toString());
    }

    public void clickOnAreYou18No() throws Exception {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.PXP_AGEGATENO_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,10000);
        logger.info("Click On No button ");
        Grimlock.eventService().trackEvents(INTERACT_AGE_GATE_FAIL_CLICK.toString());
    }

    public void clickOnCloseButton() throws Exception {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.PXP_PXPCLOSEBUTTON_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,10000);
//        Thread.sleep(15000);
//        Grimlock.eventService().trackEvents(NAVIGATE_CLOSE_CLICK.toString());
//        Thread.sleep(20000);
//        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.PXP_PXPCLOSEBUTTON_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,20000);

        Grimlock.eventService().trackEvents(NAVIGATE_CLOSE_CLICK.toString());
        logger.info("Click On Close button ");
    }

}
