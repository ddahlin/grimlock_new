package GrimlockFramework.DriverCommands.DriverUtils;

import GrimlockFramework.DriverCommands.DriverServices.GeneralServices;
import GrimlockFramework.DriverCommands.DriverServices.MobileServices;
import GrimlockFramework.DriverCommands.Utils;
import GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class MobileNativeUtils implements Utils {
    private MobileServices mobileServices;
    private GeneralServices generalServices;
    public MobileNativeUtils(AppiumDriver driver) {
        mobileServices = new MobileServices(driver);
        generalServices = new GeneralServices();
    }

    public String takeScreenshot(WebDriver driver, String targetImgPath) {
        return mobileServices.takeMobileScreenshot((AppiumDriver)driver);
    }


    public void switchTo(WebDriver grimlockDriver, String text) {
        if (mobileServices.isAppleDevice((AppiumDriver) grimlockDriver)) AppleSwitchTo(grimlockDriver, text);
        else grimlockDriver.navigate().back();

    }

    public Capabilities getCapabilities(WebDriver driver) {
        return mobileServices.getMobileCapabilities(driver);
    }


    public void hideKeyBoard(WebDriver driver) {
        mobileServices.mobileHideKeyBoard((AppiumDriver)driver);
    }


    public WebElement getElementByXpath(WebDriver driver, String xpath) {
        return generalServices.getElementByXpath(driver, xpath);
    }


    public WebElement getElementById(WebDriver driver, String id) {
        return generalServices.getElementById(driver, id);
    }


    public WebElement getElementByCssSelector(WebDriver driver, String css) {
        return generalServices.getElementByCssSelector(driver, css);
    }


    public void clickOnCoords(WebDriver driver, Point point, String targetImgPath) {
        mobileServices.tapOnCoords((AppiumDriver)driver, point);
    }


    public Point getCoords(WebDriver driver, String ScreenShotPath, String target, OpenCvSubImageDetection.RECOGNITION_MODE recognition_mode) {
        return mobileServices.getMobileCoords(0, ScreenShotPath, target, recognition_mode);
    }


    public void sendKeys(WebDriver grimlockDriver, String text) {
        mobileServices.sendKeys((AppiumDriver)grimlockDriver, text);
    }

    private void AppleSwitchTo(WebDriver grimlockDriver, String text) {
        ((AppiumDriver) grimlockDriver).activateApp(text);
    }
}
