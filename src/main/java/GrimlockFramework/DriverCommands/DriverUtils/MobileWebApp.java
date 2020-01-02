package GrimlockFramework.DriverCommands.DriverUtils;

import GrimlockFramework.DriverCommands.DriverServices.GeneralServices;
import GrimlockFramework.DriverCommands.DriverServices.JavaScriptServices;
import GrimlockFramework.DriverCommands.DriverServices.MobileServices;
import GrimlockFramework.DriverCommands.Utils;
import GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection;
import GrimlockInitialisation.CoreInitialisation.GrimlockApi;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.Set;

public class MobileWebApp implements Utils {
    private MobileServices mobileServices;
    private GeneralServices generalServices;

    public MobileWebApp(AppiumDriver driver) {
        mobileServices = new MobileServices(driver);
        generalServices = new GeneralServices();
    }

    public String takeScreenshot(WebDriver driver, String targetImgPath) {
        switchToWebContext((AppiumDriver) driver);
        if(GrimlockApi.params().Device.get("platform").toString().equals("ios"))
            mobileServices.zoomBackToDefaultZoomLevel((AppiumDriver) driver);
        String screenshotPath = mobileServices.takeMobileScreenshot((AppiumDriver) driver);
        switchToNativeContext((AppiumDriver) driver);
        return screenshotPath;
    }

    public void switchTo(WebDriver grimlockDriver, String text) {
        switchToNativeContext((AppiumDriver) grimlockDriver);
        if (mobileServices.isAppleDevice((AppiumDriver) grimlockDriver))
            AppleSwitchTo((AppiumDriver) grimlockDriver, text);
        else grimlockDriver.navigate().back();
        switchToWebContext((AppiumDriver) grimlockDriver);
    }

    private void AppleSwitchTo(AppiumDriver grimlockDriver, String text) {
        Set<String> contextNames = grimlockDriver.getContextHandles();
        grimlockDriver.context(contextNames.toArray()[contextNames.size() - 1].toString());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        grimlockDriver.close();
    }

    public Capabilities getCapabilities(WebDriver driver) {
        return mobileServices.getMobileCapabilities(driver);
    }

    public void hideKeyBoard(WebDriver driver) {
        mobileServices.mobileHideKeyBoard((AppiumDriver) driver);

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
        switchToNativeContext((AppiumDriver) driver);
        mobileServices.tapOnCoords((AppiumDriver) driver, point);
        switchToWebContext((AppiumDriver) driver);
    }

    public Point getCoords(WebDriver driver, String ScreenShotPath, String target, OpenCvSubImageDetection.RECOGNITION_MODE recognition_mode) {
        switchToWebContext((AppiumDriver) driver);
        int originalTargetScreenWidth = 0;
        if (target != null)
            originalTargetScreenWidth = getOriginalTargetScreenWidth((AppiumDriver) driver, target);
        switchToNativeContext((AppiumDriver) driver);
        return mobileServices.getMobileCoords(originalTargetScreenWidth, ScreenShotPath, target, recognition_mode);
    }

    public void sendKeys(WebDriver grimlockDriver, String text) {
        switchToNativeContext((AppiumDriver) grimlockDriver);
        mobileServices.sendKeys((AppiumDriver) grimlockDriver, text);
        switchToWebContext((AppiumDriver) grimlockDriver);
    }


    private void switchToWebContext(AppiumDriver grimlockDriver) {
        Set<String> contextNames = grimlockDriver.getContextHandles();
        grimlockDriver.context(contextNames.toArray()[1].toString());
    }

    private void switchToNativeContext(AppiumDriver grimlockDriver) {
        Set<String> contextNames = grimlockDriver.getContextHandles();
        grimlockDriver.context(contextNames.toArray()[0].toString());
    }

    private int getOriginalTargetScreenWidth(AppiumDriver grimlockDriver, String target) {
        double viewPortZoom = extractViewPortZoom(grimlockDriver);
        int playerScreenWidth = generalServices.getReferenceOriginElement(grimlockDriver, target).getSize().getWidth();
        int originalTargetScreenWidth = (int) (viewPortZoom * (double) playerScreenWidth);
        return originalTargetScreenWidth;
    }

    private double extractViewPortZoom(AppiumDriver driver) {
        JavaScriptServices javaScriptServices = new JavaScriptServices(driver);
        Object devicePixel = javaScriptServices.getDevicePixel();
        double windowScreenWidth = javaScriptServices.getWindowScreenWidth();
        double clientWidth = javaScriptServices.getClientWidth();
        return (windowScreenWidth * ((Number) devicePixel).doubleValue()) / clientWidth;
    }

}
