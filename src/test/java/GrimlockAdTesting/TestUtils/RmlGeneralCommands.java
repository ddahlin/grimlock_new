package GrimlockAdTesting.TestUtils;

import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class RmlGeneralCommands {
    public static final Logger logger = Logger.getLogger(RmlGeneralCommands.class);
    public static final String REDIRECT_URL = "https://www.tremorvideo.com/expertise/technology/";



    public void clickPreroll() {

        try {
            Thread.sleep(5000);
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)
                    Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.RML_JW_AD_VIDEO_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1600, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);


            logger.info("Click On Preroll ");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void clickPrerollforAFD() {

        try {
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_SPR_CLICK_PREROLL_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1440, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click On Preroll ");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void releaseAd() {

        try {
            Thread.sleep(5000);
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.RML_JW_AD_VIDEO_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1600, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click On Preroll ");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void checkVideoContent() {

        try {
            Grimlock.grimlockDriver().waitUntilImageLocationFound(ImageConstants.RML_JW_VIDEO_CONTENT_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1600, OpenCvSubImageDetection.RECOGNITION_MODE.STRICT,90000);
            logger.info("Found Video Content");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void checkRedirectURL(String url) {

            WebDriver webDriver;
            webDriver = Grimlock.grimlockDriver().getDriverFramework();

        if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null) {

            if (Grimlock.params().IS_MOBILE) {
                try {
                    Thread.sleep(3000);
                    Grimlock.grimlockDriver().waitUntilImageLocationFound(ImageConstants.ANDROID_CHECK_REDIRECT_PAGE, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
                    logger.info("Found Redirected Page");

                    Grimlock.grimlockDriver().moveToTabOrApp("com.tremorvideo.JWPlayer3Demo");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {

                ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
                webDriver.switchTo().window(tabs.get(1));
                try {
                    new WebDriverWait(webDriver, 15).until(ExpectedConditions.urlContains(url));
                    logger.info("Found Redirected Page");
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                webDriver.close();
                webDriver.switchTo().window(tabs.get(0));
                webDriver.switchTo().defaultContent();
            }
        }
    }
    public void clickBug(){
        try {
            Thread.sleep(5000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_BUG_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1600, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Bug");
    }catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void closeSlate(){
        try {
            Thread.sleep(5000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_CLOSE_SLATE_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1600, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Close Slate");
    }catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void clickSlate(){
        try {
            Thread.sleep(3000);
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_CLICK_SLATE_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1600_DATUM_X_44_Y_226, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Slate");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickSPRASlate(){
        try {
            Thread.sleep(3000);
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_SPRA_CLICK_SLATE_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080_DATUM_X_65_Y_246, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Slate");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickSPRABlueSlate(){
        try {
            Thread.sleep(3000);
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_SPRA_CLICK_SLATE_BLUE_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080_DATUM_X_71_Y_197, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Slate");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickSlatePage1(){
        try {
            Thread.sleep(3000);
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_SPRA_PAGE01_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Slate");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickSlatePage2(){
        try {
            Thread.sleep(3000);
            if ((Grimlock.params().Website != null && !Grimlock.params().Website.get("browser").toString().toLowerCase().equals("safari"))||Grimlock.params().Application != null)
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_SPRA_PAGE02_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Slate");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickResume(){
        try {
            Thread.sleep(3000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_SPRA_RESUME_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Slate");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickPhoto360(){
        try {
            Thread.sleep(3000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_360_PHOTO_CLICK_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080_DATUM_X_39_Y_37, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Photo 360");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickVideo360(){
        try {
            Thread.sleep(3000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_VIDEO360_CLICK_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click Video 360");
            Thread.sleep(60000);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickYes(){
        try {
            Thread.sleep(5000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_YES_BTN_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1440, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED,30000);
            logger.info("Click Yes");


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickNo(){
        try {
            Thread.sleep(15000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_NO_BTN_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1440, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click No");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickToContinue(){
        try {
            Thread.sleep(20000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_CLICK_TO_CONT_BASEELEMENTID_PLAYER_WIDTH_2560_HEIGHT_1440, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click To Continue");
            Thread.sleep(60000);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickPlaySecondaryVideo(){
        try {
            Thread.sleep(3000);
            Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ADFORMATS_JW_SEC_VID_CLICK_BASEELEMENTID_PLAYER_WIDTH_1920_HEIGHT_1080_DATUM_X_45_Y_32, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
            logger.info("Click To Second Video");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

