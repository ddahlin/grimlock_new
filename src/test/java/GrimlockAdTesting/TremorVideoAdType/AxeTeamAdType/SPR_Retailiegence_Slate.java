package GrimlockAdTesting.TremorVideoAdType.AxeTeamAdType;


import GrimlockAdTesting.Application.ApplicationBuilder;
import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import GrimlockAdTesting.TremorVideoAdType.VastGeneralCommands;
import GrimlockFramework.DriverCommands.GrimlockDriver;
import org.apache.log4j.Logger;

import static GrimlockAdTesting.TestUtils.EventEnums.INTERACT_RETAILIGENCE_CLICK;
import static GrimlockAdTesting.TestUtils.EventEnums.NAVIGATE_CLOSE_CLICK;
import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED;
import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE.STRICT;
import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class SPR_Retailiegence_Slate extends VastGeneralCommands {
    private static final Logger logger = Logger.getLogger(SPR_Retailiegence_Slate.class);

    public ApplicationBuilder applicationBuilder;
    private GrimlockDriver driver;
    public SPR_Retailiegence_Slate() {
        driver = Grimlock.grimlockDriver();
        applicationBuilder = new ApplicationBuilder(driver, Grimlock.params());
    }
    public void sendZipCodeToInputFild(String zipCode) {
        try {
            driver.sendKeyToImageLocation(ImageConstants.SLATE_ENTERZIPCODEWITHPOINT_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1080_DATUM_X_85_Y_30, zipCode,RELAXED);
//            Grimlock.eventService().trackEvents(INTERACT_RETAILIGENCE_CLICK.toString());
//            Grimlock.eventService().trackEvents(INTERACT_RETAILIGENCE_CLICK.toString());
            driver.clickOnImageLocation(ImageConstants.SLATE_SEARCHSLATE_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1031, RELAXED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CloseSlateCompanent() throws Exception {
        driver.clickOnImageLocation(ImageConstants.SLATE_CLOSESLATE_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1031, STRICT);
        Grimlock.eventService().trackEvents(NAVIGATE_CLOSE_CLICK.toString());
        logger.info("clickCloseSlateCompanent");
    }

    public void clickOnGps() throws Exception {
        driver.clickOnImageLocation(ImageConstants.SLATE_GPSSLATE_BASEELEMENTID_TESGREENAYTED3_WIDTH_1920_HEIGHT_1031, STRICT);
        Thread.sleep(3000);
        logger.info("Return to JwPlayer application");

        if (isMobile())
            driver.moveToTabOrApp("com.tremorvideo.JWPlayer3Demo");
        else
            driver.moveToTabOrApp(Grimlock.grimlockDriver().getWindowName());

    }


    private boolean isMobile() {
        return driver.getCapabilities().getBrowserName().isEmpty();
    }
}
