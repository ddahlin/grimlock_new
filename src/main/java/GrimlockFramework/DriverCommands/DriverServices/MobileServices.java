package GrimlockFramework.DriverCommands.DriverServices;

import GrimlockFramework.ImageRecognition.Tools.ImageActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE;
import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE.RELAXED;

public class MobileServices {
    JavaScriptServices javaScriptServices;
    BufferedImage screenshotImage;
    ImageActions imageActions;
    GeneralServices generalServices;
    public MobileServices(AppiumDriver driver) {
        imageActions = new ImageActions();
        javaScriptServices = new JavaScriptServices(driver);
        generalServices = new GeneralServices();
    }

    public void mobileHideKeyBoard(AppiumDriver grimlockDriver) {
        String deviceName = getMobileCapabilities(grimlockDriver).getCapability("deviceName").toString();
        if (deviceName.toLowerCase().toLowerCase().contains("iphone"))
            clickOnDone( grimlockDriver);
        if (deviceName.toLowerCase().toLowerCase().contains("ipad"))
            ( grimlockDriver).hideKeyboard();
    }

    public void tapOnCoords(AppiumDriver driver, Point pointToTap) {
        pointToTap = reCalculatePointForDiffrentSizeImage(pointToTap, calculateScale(screenshotImage.getWidth(), driver.manage().window().getSize().width));
        TouchAction touchAction = new TouchAction(( driver));
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(pointToTap.x, pointToTap.y))).perform();
    }

    public String takeMobileScreenshot(AppiumDriver driver) {
        File mobileScreenshotFile = generalServices.getScreenshotAsFile(driver);
        try {
            screenshotImage = ImageIO.read(mobileScreenshotFile);
            ImageIO.write(screenshotImage, "png", mobileScreenshotFile);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return mobileScreenshotFile.getAbsolutePath();
    }

    public Point getMobileCoords(int originalTargetScreenWidth, String screenshotPath, String subImagePath, RECOGNITION_MODE recognitionMode) {
        if (originalTargetScreenWidth == 0) originalTargetScreenWidth = screenshotImage.getWidth();
        return imageActions.getCoords(subImagePath, screenshotPath, recognitionMode, originalTargetScreenWidth);
    }

    public Capabilities getMobileCapabilities(WebDriver driver) {
        return ((AppiumDriver) driver).getCapabilities();
    }


    public void sendKeys(AppiumDriver driver, String keys) {
        if (isAppleDevice( driver)) sendKeysToAppleDevice((AppiumDriver<MobileElement>) driver, keys);
        else sendKeysToAndroidDevice( driver, keys);
    }


    /**
     * iphone using point for display and not pixel
     * for IOS uses this method convert depending the device the new point
     * to press or click
     *
     * @param pointFromOrginImage point
     * @param scale               float
     * @return new point after calc
     */
    private Point reCalculatePointForDiffrentSizeImage(Point pointFromOrginImage, double scale) {
        if (scale == 0) scale = ((Number) javaScriptServices.getDevicePixel()).doubleValue();
        return new Point((int) (pointFromOrginImage.x / scale), (int) (pointFromOrginImage.y / scale));
    }

    /**
     * calc the scale of the convert
     *
     * @param orginImageWidth          int
     * @param grimlockDriverImageWidth int
     * @return new int after calc
     */
    private double calculateScale(int orginImageWidth, int grimlockDriverImageWidth) {
        return orginImageWidth / grimlockDriverImageWidth;
    }

    public boolean isAppleDevice(AppiumDriver grimlockDriver) {
        return getMobileCapabilities(grimlockDriver).getCapability("platformName").toString().toLowerCase().contains("ios");
    }

    public boolean isAndroidDevice(AppiumDriver grimlockDriver) {
        return getMobileCapabilities(grimlockDriver).getCapability("platformName").toString().toLowerCase().contains("android");
    }

    private void sendKeysToAppleDevice(AppiumDriver grimlockDriver, String text) {
        grimlockDriver.switchTo().activeElement().sendKeys(text);
    }

    private void sendKeysToAndroidDevice(AppiumDriver grimlockDriver, String text) {
        new Actions(grimlockDriver).sendKeys(text).build().perform();
    }

    /**
     * close the keyboard of the mobile device
     *
     * @param driver getting the grimlockDriver
     */

    private void clickOnDone(AppiumDriver driver) {
        String doneImage = "./src/main/resources/Images/target/general/doneKeyboard-width-1125-height-2436.png";
        String ScreenshotPath = takeMobileScreenshot(driver);
        tapOnCoords(driver, this.imageActions.getCoords(doneImage, ScreenshotPath, RELAXED, screenshotImage.getWidth()));
    }
    public void zoomBackToDefaultZoomLevel(AppiumDriver grimlockDriver) {
        Object zoom = getZoomLevel(grimlockDriver);
        while (((Number) zoom).floatValue() != (float) 1) {
            doubleTapForZoomOut(grimlockDriver);
            zoom = getZoomLevel(grimlockDriver);
        }
    }

    public void doubleTapForZoomOut(AppiumDriver grimlockDriver) {
        Map<String, Object> args = new HashMap<>();
        if(screenshotImage==null) takeMobileScreenshot(grimlockDriver);
        Point middleScreen = reCalculatePointForDiffrentSizeImage(new Point(screenshotImage.getWidth() / 2, screenshotImage.getHeight() / 2), calculateScale(screenshotImage.getWidth(), grimlockDriver.manage().window().getSize().width));
        args.put("x", middleScreen.x);args.put("y", middleScreen.y);
        ((AppiumDriver) grimlockDriver).executeScript("mobile: doubleTap", args);
    }

    public Object getZoomLevel(AppiumDriver grimlockDriver) {
        Object zoom;
        if (isAppleDevice(grimlockDriver)) zoom = javaScriptServices.getSafariZoomLevel();
        else zoom = javaScriptServices.getChromeZoomLevel();
        return zoom;
    }

}
