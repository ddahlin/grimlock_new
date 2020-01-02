package GrimlockAdTesting.Application.VastApplicationImplements;

import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import GrimlockEventHandler.NetworkSniffer.Charles.CharlesParsers;
import GrimlockFramework.DriverCommands.GrimlockDriver;
import GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection;
import javafx.util.Pair;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class JwPlayerCommands {
    GrimlockDriver grimlockDriver;
    String iosUrlFild = "./src/main/resources/Images/target/Application/JW_Player/ios/vastTag-width-1125-height-2436.png";
    Pair<GrimlockDriver.SELECTOR_METHOD, String> UiButn = new Pair<>(GrimlockDriver.SELECTOR_METHOD.XPATH, "//XCUIElementTypeButton[@label=\"play button\"]");
    Pair<String, String> playBtn = new Pair<>("image", "./src/main/resources/Images/target/Application/JW_Player/ios/playBtn-width-1125-height-2436.png");
    VastInspectorPage vastInspectorPage;

    public JwPlayerCommands(GrimlockDriver driver) {
        grimlockDriver = driver;

    }

    public void setupAdInApp(String xml) {
        try {
            String platformName = grimlockDriver.getCapabilities().getCapability("platformName").toString();
            if (Grimlock.grimlockDriver().getCapabilities().getBrowserName().isEmpty()) {
                switch (platformName.toLowerCase()) {
                    case "ios":
                        iosScenario(xml);
                        break;
                    case "android":
                        androidScenario(xml);
                        break;
                }
            }else {
                vastInspectorPage = new VastInspectorPage();
                vastInspectorPage.setupAdInApp(xml);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void androidScenario(String xml) throws InterruptedException {
        clickOnAndroidInput();
        sendVastToAndroidInputFild(xml);
        clickOnOk();
        Thread.sleep(2000);
        clickOnPlayVideoBtn();
    }

    private void clickOnOk() {
        grimlockDriver.clickOnImageLocation(ImageConstants.ANDROID_OKBUTTN);
    }

    private void sendVastToAndroidInputFild(String xml) {
        grimlockDriver.sendKeys(xml);
    }

    private void clickOnAndroidInput() {
        grimlockDriver.clickOnImageLocation(ImageConstants.ANDROID_ANDROID9);
    }


    private void clickOnPlayVideoBtn() {
        grimlockDriver.clickOnImageLocation(ImageConstants.IOS_PLAYBTN_WIDTH_1125_HEIGHT_2436);
    }

    private void clickOnPlayUIBtn() {
        grimlockDriver.clickOnElement(UiButn.getKey(), UiButn.getValue());
    }

    private void sendVastToInputFild(String xml) throws InterruptedException {
        grimlockDriver.sendKeys(xml);
    }

    private void clickOnIosInputFild() {
       // grimlockDriver.clickOnImageLocation(ImageConstants.IOS_VASTTAG_WIDTH_1125_HEIGHT_2436);
        grimlockDriver.clickOnImageLocation(ImageConstants.IOS_IOS_VAST_ENTRY, OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED);
    }


    private void iosScenario(String xml) throws InterruptedException {
        clickOnIosInputFild();
        sendVastToInputFild(xml);
        clickOnPlayUIBtn();
        Thread.sleep(2000);
        clickOnPlayVideoBtn();
    }

}
