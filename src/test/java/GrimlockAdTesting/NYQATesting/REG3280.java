package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3280 {
    public RmlGeneralCommands rmlGeneralCommands;
    //public static EventUtils eventUtils;

    @BeforeMethod(groups = "REG3280")
    public void initREG3280test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        applicationBuilder.setUpAdInApp("3280");

        rmlGeneralCommands = new RmlGeneralCommands();
    }

    @Test(groups = "REG3280")
    public void SPRwithEngagement() throws Exception {
        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.clickSlate();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.clickBug();
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_ONE_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_CLICK_SLATE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NAVIGATE_CLOSE_CLICK_TWO_PIXEL_MAP.entrySet());
    }

    }

