package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG2989 {

    public RmlGeneralCommands rmlGeneralCommands;
    @BeforeMethod(groups = {"REG2989a","REG2989b"})
    public void initREG2989test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE && Grimlock.params().Application!=null)
            applicationBuilder.setUpAdInApp(InappAdTags.REG2989);
        else
            applicationBuilder.setUpAdInApp("E2E_JS_SPR");

        rmlGeneralCommands = new RmlGeneralCommands();
    }


    @Test(groups = "REG2989a")
    public void SPRNoEngagement() throws Exception {

        Thread.sleep(15000);
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.NO_ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());

    }
    @Test(groups = "REG2989b")
    public void SPRwithEngagement() throws Exception {
        rmlGeneralCommands.clickPrerollforAFD();
        rmlGeneralCommands.clickSlate();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.clickBug();
        rmlGeneralCommands.closeSlate();
        rmlGeneralCommands.checkVideoContent();


        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());

        EventUtils.checkPixels(TrackingPixels.ENGAGE_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.MEDIA_PROGRESS_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.SPR_PIXEL_MAP.entrySet());
        if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("firefox"))||Grimlock.params().Application != null)
            EventUtils.checkPixels(TrackingPixels.NAVIGATE_CLOSE_CLICK_TWO_PIXEL_MAP.entrySet());
        else
            EventUtils.checkPixels(TrackingPixels.NAVIGATE_CLOSE_CLICK_ONE_PIXEL_MAP.entrySet());

        if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)  {
            EventUtils.checkPixels(TrackingPixels.EC_ONE_CLICK_PIXEL_MAP.entrySet());
            EventUtils.checkPixels(TrackingPixels.SPR_CLICK_SLATE_PIXEL_MAP.entrySet());
        }

        }

    }
