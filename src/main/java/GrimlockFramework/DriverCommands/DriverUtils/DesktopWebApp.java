package GrimlockFramework.DriverCommands.DriverUtils;

import GrimlockFramework.DriverCommands.DriverServices.GeneralServices;
import GrimlockFramework.DriverCommands.DriverServices.WebServices;
import GrimlockFramework.DriverCommands.Utils;
import GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class DesktopWebApp implements Utils {
    private GeneralServices generalServices;
    private WebServices webServices;
    public DesktopWebApp(WebDriver driver)
    {
        webServices = new WebServices(driver);
        generalServices = new GeneralServices();
    }
    public String takeScreenshot(WebDriver driver, String targetImgPath) {
        return webServices.takeWebScreenshot(driver,targetImgPath);
    }


    public void switchTo(WebDriver grimlockDriver, String text) {
        webServices.switchTo(grimlockDriver,text);
    }


    public Capabilities getCapabilities(WebDriver driver) {
        return webServices.getCapabilities(driver);
    }


    public void hideKeyBoard(WebDriver driver) {

    }


    public WebElement getElementByXpath(WebDriver driver, String xpath) {
        return generalServices.getElementByXpath(driver,xpath);
    }


    public WebElement getElementById(WebDriver driver, String id) {
        return generalServices.getElementById(driver,id);
    }


    public WebElement getElementByCssSelector(WebDriver driver, String css) {
        return generalServices.getElementByCssSelector(driver,css);
    }


    public void clickOnCoords(WebDriver driver, Point point, String targetImgPath) {
        webServices.clickOnWebCoords(driver,point,targetImgPath);
    }


    public Point getCoords(WebDriver driver, String ScreenShotPath, String target, OpenCvSubImageDetection.RECOGNITION_MODE recognition_mode) {
        return webServices.getWebCoords(ScreenShotPath,target,recognition_mode);
    }


    public void sendKeys(WebDriver grimlockDriver, String text) {
        webServices.sendKeysToWeb(grimlockDriver,text);
    }
}
