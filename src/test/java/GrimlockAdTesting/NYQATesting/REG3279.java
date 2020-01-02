package GrimlockAdTesting.NYQATesting;

import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TestUtils.EventUtils;
import GrimlockAdTesting.TestUtils.RmlGeneralCommands;
import GrimlockFramework.Utils.TrackingPixels;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class REG3279 {
    public RmlGeneralCommands rmlGeneralCommands;

    @BeforeMethod(groups = "REG3279")
    public void initREG3279test() throws Exception {
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(Grimlock.grimlockDriver(), Grimlock.params());
            applicationBuilder.setUpAdInApp("3279");

        rmlGeneralCommands = new RmlGeneralCommands();
    }

    @Test(groups = "REG3279")
    public void firstTest() throws Exception {

        rmlGeneralCommands.clickPreroll();
        rmlGeneralCommands.checkRedirectURL(RmlGeneralCommands.REDIRECT_URL);
        rmlGeneralCommands.releaseAd();
        rmlGeneralCommands.checkVideoContent();

        EventUtils.checkPixels(TrackingPixels.EC_PIXEL_VAST_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.EC_ONE_CLICK_PIXEL_MAP.entrySet());
        EventUtils.checkPixels(TrackingPixels.REG3279_CUSTOM_PIXEL_MAP.entrySet());


    }

}

