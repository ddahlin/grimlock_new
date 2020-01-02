package GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import org.apache.log4j.Logger;
import static GrimlockAdTesting.TestUtils.EventEnums.*;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;


public class SecondaryVideo extends Pxp {
    private static final Logger logger = Logger.getLogger(Pxp.class);
    public ApplicationBuilder applicationBuilder;

    public SecondaryVideo() {
        applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
    }

    public void clickOnPlaySecondaryVideo() throws Exception {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.SECONDARYVIDEO_TEST_BASEELEMENTID_TESGREENAYTED3_WIDTH_2560_HEIGHT_1600,30000);
        logger.info("Click On Ad Play");
        Grimlock.eventService().trackEvents(MEDIA_PROGRESS_SECONDARY_VIDEO_0.toString());
        logger.info("Assert - MEDIA_PROGRESS_SECONDARY_VIDEO_0");
    }

    public void clickOnPauseSecondaryVideo() throws Exception {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.SECONDARYVIDEO_PAUSE_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,30000);
        logger.info("Click On Ad Pause");
    }

    public void clickOnCloseSecondaryVideo() throws Exception {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.SECONDARYVIDEO_CLOSE_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080,30000);
        logger.info("Click On Ad Close");
        Grimlock.eventService().trackEvents(NAVIGATE_CLOSE_CLICK.toString());
        logger.info("Assert - NAVIGATE_CLOSE_CLICK");
    }
}
