package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3212 {

    public RmlGeneralCommands rmlGeneralCommands;

   @BeforeMethod(groups = {"REG3212a","REG3212b"})

    public void initREG3212test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE)
            applicationBuilder.setUpAdInApp(InappAdTags.REG3212);
        else
            applicationBuilder.setUpAdInApp("E2E_JS_PXP_ST_NC");

        rmlGeneralCommands = new RmlGeneralCommands();
    }


    @Test(groups = "REG3212a")
    public void PXPNoEngagement() throws Exception {
        Thread.sleep(15000);
        rmlGeneralCommands.checkVideoContent();
        
        EventUtils.checkPixels(TrackingPixels.EC_PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_38_NULL_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NO_ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_TEASER_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_TEASER_PROGRESS_PIXEL_MAP.entrySet());

    }


    @Test(groups = "REG3212b")
    public void PXPClickToCont() throws Exception {
        rmlGeneralCommands.clickToContinue();
        rmlGeneralCommands.clickBug();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        Thread.sleep(60000);
        rmlGeneralCommands.checkVideoContent();
        
        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_TWO_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_TEASER_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_LONGFORM_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_TEASER_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_LONGFORM_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_CLICK_TO_CONT_PIXEL_MAP.entrySet());

    }

}

