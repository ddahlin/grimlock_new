package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.InappAdTags;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3202 {
    public RmlGeneralCommands rmlGeneralCommands;

    @BeforeMethod(groups = "REG3202")
    public void initREG3202test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
        if (Grimlock.params().IS_MOBILE && Grimlock.params().Application!=null)
            applicationBuilder.setUpAdInApp(InappAdTags.REG3202);
        else
            applicationBuilder.setUpAdInApp("3202_RML");

        rmlGeneralCommands = new RmlGeneralCommands();
    }

    @Test(groups = "REG3202")
    public void firstTest() throws Exception {
      rmlGeneralCommands.clickPreroll();
      rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
      rmlGeneralCommands.releaseAd();
      rmlGeneralCommands.checkVideoContent();


        if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null) {
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("firefox"))||Grimlock.params().Application != null)
                EventUtils.checkPixels(TrackingPixels.EC_TWO_CLICK_PIXEL_MAP.entrySet());
            else EventUtils.checkPixels(TrackingPixels.EC_ONE_CLICK_PIXEL_MAP.entrySet());
            EventUtils.checkPixels(TrackingPixels.EC_PIXEL_MAP.entrySet());
        }

      EventUtils.checkPixels(TrackingPixels.REG3202_CUSTOM_PIXEL_MAP.entrySet());



    }





}

