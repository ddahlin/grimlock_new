package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3145 {

    public RmlGeneralCommands rmlGeneralCommands;

    @BeforeMethod(groups = "REG3145")
    public void initREG3145test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE)
            applicationBuilder.setUpAdInApp(InappAdTags.REG3145);
        else
            applicationBuilder.setUpAdInApp("E2E_JS_SPR_PHOTO_360");

        rmlGeneralCommands = new RmlGeneralCommands();
    }



    @Test(groups = "REG3145")
    public void SPRwithEngagement() throws Exception {
        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.clickPhoto360();
        rmlGeneralCommands.clickSlate();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.clickBug();
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_TWO_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_CLICK_SLATE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NAVIGATE_CLOSE_CLICK_ONE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_PHOTO_360_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_VIEW_SLATE_TWO_PIXEL_MAP.entrySet());
    }

}

