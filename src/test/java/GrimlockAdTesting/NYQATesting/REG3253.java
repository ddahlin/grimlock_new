package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3253 {

    public RmlGeneralCommands rmlGeneralCommands;
    @BeforeMethod(groups = {"REG3253a","REG3253b"})
    public void initREG3253test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE)
            applicationBuilder.setUpAdInApp(InappAdTags.REG3253);
        else
            applicationBuilder.setUpAdInApp("E2E_JS_SPRE");

        rmlGeneralCommands = new RmlGeneralCommands();
    }


    @Test(groups = "REG3253a")
    public void SPRNoEngagement() throws Exception {

        Thread.sleep(15000);
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_SPRE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NO_ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());

    }
    @Test(groups = "REG3253b")
    public void SPRwithEngagement() throws Exception {

        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.clickBug();
        rmlGeneralCommands.clickSlate();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.checkVideoContent();


        EventUtils.checkPixels(TrackingPixels.EC_SPRE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_ONE_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NAVIGATE_CLOSE_CLICK_ONE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_VIEW_SLATE_TWO_PIXEL_MAP.entrySet());
    }

}

