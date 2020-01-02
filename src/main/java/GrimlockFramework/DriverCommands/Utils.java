package GrimlockFramework.DriverCommands;

import static   GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE  ;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public interface  Utils {

     String takeScreenshot(WebDriver driver, String targetImgPath);

     void switchTo(WebDriver grimlockDriver, String text);

     Capabilities getCapabilities(WebDriver driver);

     void hideKeyBoard(WebDriver driver);

     WebElement getElementByXpath(WebDriver driver, String xpath) ;

     WebElement getElementById(WebDriver driver, String id);

     WebElement getElementByCssSelector(WebDriver driver, String css);

     void clickOnCoords(WebDriver driver, Point point, String targetImgPath);

     Point getCoords(WebDriver driver,String ScreenShotPath, String target, RECOGNITION_MODE recognition_mode);

     void sendKeys(WebDriver grimlockDriver, String text);

}
