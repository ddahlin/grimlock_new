package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3258 {

    public RmlGeneralCommands rmlGeneralCommands;
    @BeforeMethod(groups = {"REG3258a","REG3258b"})
    public void initREG3258test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE)
            applicationBuilder.setUpAdInApp(InappAdTags.REG3258);
        else
            applicationBuilder.setUpAdInApp("E2E_JS_SPRA");

        rmlGeneralCommands = new RmlGeneralCommands();
    }


    @Test(groups = "REG3258a")
    public void SPRNoEngagement() throws Exception {

        Thread.sleep(15000);
        rmlGeneralCommands.checkVideoContent();
        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NO_ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());

    }
    @Test(groups = "REG3258b")
    public void SPRwithEngagement() throws Exception {
        rmlGeneralCommands.clickSlatePage1();
        rmlGeneralCommands.clickSPRASlate();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.clickSlatePage2();
        rmlGeneralCommands.clickSPRABlueSlate();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.clickResume();
        rmlGeneralCommands.clickSlatePage1();
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_TWO_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPRA_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_VIEW_SLATE_TWO_PIXEL_MAP.entrySet());
    }

}

