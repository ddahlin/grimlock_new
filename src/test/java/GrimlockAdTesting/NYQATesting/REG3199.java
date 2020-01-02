package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3199 {

    public RmlGeneralCommands rmlGeneralCommands;

    @BeforeMethod(groups = "REG3199")
    public void initREG3199test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE)
            applicationBuilder.setUpAdInApp(InappAdTags.REG3199);
        else
            applicationBuilder.setUpAdInApp("E2E_JS_SPR_SECONDARY_VIDEO");

        rmlGeneralCommands = new RmlGeneralCommands();
    }



    @Test(groups = "REG3199")
    public void SPRwithEngagement() throws Exception {

        rmlGeneralCommands.clickBug();
        Thread.sleep(15000);
        rmlGeneralCommands.clickPlaySecondaryVideo();
        Thread.sleep(15000);
        rmlGeneralCommands.clickSlate();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.clickPrerollforAFD();
        Thread.sleep(15000);
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_ONE_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_CLICK_SLATE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NAVIGATE_CLOSE_CLICK_TWO_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_SECONDARY_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_VIEW_SLATE_TWO_PIXEL_MAP.entrySet());
    }

}

