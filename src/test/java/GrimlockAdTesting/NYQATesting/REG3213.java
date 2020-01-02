package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3213 {

    public RmlGeneralCommands rmlGeneralCommands;
   @BeforeMethod(groups = {"REG3213a","REG3213b","REG3213c"})

    public void initREG3213test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE)
            applicationBuilder.setUpAdInApp(InappAdTags.REG3213);
        else
            applicationBuilder.setUpAdInApp("E2E_JS_PXP_AG_C");

        rmlGeneralCommands = new RmlGeneralCommands();
    }


    @Test(groups = "REG3213a")
    public void PXPNoEngagement() throws Exception {

        Thread.sleep(5000);
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_38_NULL_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NO_ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_TEASER_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_TEASER_PROGRESS_PIXEL_MAP.entrySet());

    }


    @Test(groups = "REG3213b")
    public void PXPClickYes() throws Exception {
        rmlGeneralCommands.clickYes();
        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.clickBug();
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
        EventUtils.checkPixels(TrackingPixels.PXP_LONGFORM_RED_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_AGEGATE_YES_PIXEL_MAP.entrySet());

    }
    @Test(groups = "REG3213b")
    public void PXPClickYesToCont() throws Exception {
        Cookie cookie = new Cookie("ageGate","true");
        Grimlock.grimlockDriver().grimlockDriver.manage().addCookie(cookie);
        rmlGeneralCommands.clickToContinue();
        rmlGeneralCommands.clickBug();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        Thread.sleep(60000);
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_TWO_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_TEASER_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_LONGFORM_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_TEASER_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_LONGFORM_RED_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_CLICK_TO_CONT_PIXEL_MAP.entrySet());
    }


    @Test(groups = "REG3213c")
    public void PXPClickNo() throws Exception {
        rmlGeneralCommands.clickNo();
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
        EventUtils.checkPixels(TrackingPixels.PXP_LONGFORM_GREEN_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_AGEGATE_NO_PIXEL_MAP.entrySet());
    }
    @Test(groups = "REG3213c")
    public void PXPClickNoToCont() throws Exception {
        Cookie cookie = new Cookie("ageGate","true");
        Grimlock.grimlockDriver().grimlockDriver.manage().addCookie(cookie);
        rmlGeneralCommands.clickToContinue();
        rmlGeneralCommands.clickBug();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        Thread.sleep(60000);
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_TWO_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_TEASER_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_VIEW_LONGFORM_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_TEASER_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_LONGFORM_GREEN_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.PXP_CLICK_TO_CONT_PIXEL_MAP.entrySet());
    }

}

