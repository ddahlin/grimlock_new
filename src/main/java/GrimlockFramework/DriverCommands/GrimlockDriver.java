package GrimlockFramework.DriverCommands;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.net.URL;

import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE;
import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE.STRICT;

public class GrimlockDriver {

    private final Logger logger = Logger.getLogger(GrimlockDriver.class);
    public WebDriver grimlockDriver;
    public WebElement grimlockElement;
    public Utils utils;
    private final int DEFAULT_TIME_TO_WAIT = 15000;

    public enum SELECTOR_METHOD {
        XPATH, ELEMENT_ID, CSS
    }

    /**
     * Constructor for Grimlock Driver
     *
     * @param driver getting Driver for Setting WebDriver
     * @param utils  setting Utils for mobile or web commands
     */
    public GrimlockDriver(WebDriver driver, Utils utils) {
        this.utils = utils;
        this.grimlockDriver = driver;

    }

    /**
     * After every test we will want to reset the application for more tests.
     */
    public void resetAppToNewTest() {
        ((AppiumDriver) grimlockDriver).resetApp();
    }

    /**
     * @return Web Driver ONLY FOR ADVANCED QA ENGINEER
     */
    public WebDriver getDriverFramework() {
        return grimlockDriver;
    }

    /**
     * click on element by selector
     *
     * @param selectorMethod        Selector Method
     * @param elementIdentification Element Identification
     */
    public void clickOnElement(SELECTOR_METHOD selectorMethod, String elementIdentification) {
        try {
            findElement(selectorMethod, elementIdentification);
            this.waitUntilElementFound(this.grimlockElement);
            this.grimlockElement.click();
        } catch (Exception e) {
            logger.error("Error :-(");
            e.printStackTrace();
        }
    }

    /**
     * @return The Capabilities
     */
    public Capabilities getCapabilities() {
        return utils.getCapabilities(grimlockDriver);
    }

    /**
     * Send Text to element
     *
     * @param selectorMethod        Selector Method
     * @param elementIdentification Element Identification
     * @param text                  the text to send
     */
    public void sendTextToElement(SELECTOR_METHOD selectorMethod, String elementIdentification, String text) {
        try {
            findElement(selectorMethod, elementIdentification);
            waitUntilElementFound(grimlockElement);
            grimlockElement.clear();
            grimlockElement.sendKeys(text);
        } catch (Exception e) {
            logger.error("Error :-(");
            e.printStackTrace();
        }
    }

    /**
     * getting text form element
     *
     * @param selectorMethod        Selector Method
     * @param elementIdentification Element Identification
     * @return return the text of the element
     */
    public String getTextFromElement(SELECTOR_METHOD selectorMethod, String elementIdentification) {
        this.findElement(selectorMethod, elementIdentification);
        return this.grimlockElement.getText();

    }

    /**
     * click on image element Can use in many different ways
     *
     * @param subImagePath path of the sub image file
     *                     <p>recognition_mode set to STRICT as Default
     *                     <p>milliSec set to 15000 as Default
     */
    public void clickOnImageLocation(String subImagePath) {
        clickOnImageLocation(subImagePath, STRICT, DEFAULT_TIME_TO_WAIT);
    }

    /**
     * click on image element Can use in many different ways
     *
     * @param subImagePath path of the sub image file
     *                     <p>recognition_mode set to STRICT as Default
     * @param milliSec     how many time to wait until field the test
     */
    public void clickOnImageLocation(String subImagePath, long milliSec) {
        clickOnImageLocation(subImagePath, STRICT, milliSec);
    }

    /**
     * click on image element Can use in many different ways
     *
     * @param subImagePath     path of the sub image file
     * @param recognition_mode Recognition Mode for the founding Image
     *                         <p>milliSec set to 15000 as Default
     */
    public void clickOnImageLocation(String subImagePath, RECOGNITION_MODE recognition_mode) {
        clickOnImageLocation(subImagePath, recognition_mode, DEFAULT_TIME_TO_WAIT);
    }

    /**
     * click on image element Can use in many different ways
     *
     * @param subImagePath     path of the sub image file
     * @param recognition_mode Recognition Mode for the founding Image
     * @param milliSec         how many time to wait until field the test
     */
    public void clickOnImageLocation(String subImagePath, RECOGNITION_MODE recognition_mode, long milliSec) {
        logger.info("Trying to find : "+subImagePath);
        try {
            Point point = this.waitUntilImageLocationFound(subImagePath, recognition_mode, milliSec);
            logger.info("Clicking on coords : "+point);
            if (isaImage(point))
                utils.clickOnCoords(grimlockDriver, point, subImagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isaImage(Point point) {
        return point != null && (point.x != 0 || point.y != 0);
    }

    /**
     * send Keys to Image Element Can Use In Many Ways
     *
     * @param subImagePath the sub image path to file in String
     * @param text         the text to send to the image.
     *                     <p>recognition_mode set to STRICT as Default
     *                     <p>milliSec set to 15000 as Default
     * @throws InterruptedException throw Exception
     */
    public void sendKeyToImageLocation(String subImagePath, String text) throws InterruptedException {
        sendKeyToImageLocation(subImagePath, text, STRICT, DEFAULT_TIME_TO_WAIT);
    }

    /**
     * send Keys to Image Element Can Use In Many Ways
     *
     * @param subImagePath the sub image path to file in String
     * @param text         the text to send to the image.
     *                     <p>recognition_mode set to STRICT as Default
     * @param milliSec     wait time in milliSec
     * @throws InterruptedException throw Exception
     */
    public void sendKeyToImageLocation(String subImagePath, String text, long milliSec) throws InterruptedException {
        sendKeyToImageLocation(subImagePath, text, STRICT, milliSec);
    }

    /**
     * send Keys to Image Element Can Use In Many Ways
     *
     * @param subImagePath     the sub image path to file in String
     * @param text             the text to send to the image.
     * @param recognition_mode recognition mode for Image Recognition
     *                         <p>milliSec set to 15000 as Default
     * @throws InterruptedException throw Exception
     */
    public void sendKeyToImageLocation(String subImagePath, String text, RECOGNITION_MODE recognition_mode) throws InterruptedException {
        sendKeyToImageLocation(subImagePath, text, recognition_mode, DEFAULT_TIME_TO_WAIT);
    }

    /**
     * send Keys to Image Element Can Use In Many Ways
     *
     * @param subImagePath     the sub image path to file in String
     * @param text             the text to send to the image.
     * @param recognition_mode recognition mode for Image Recognition
     * @param milliSec         wait time in milliSec
     * @throws InterruptedException throw Exception
     */
    public void sendKeyToImageLocation(String subImagePath, String text, RECOGNITION_MODE recognition_mode, long milliSec) throws InterruptedException {
        logger.info("Trying to send '"+text+"' to :"+subImagePath);
        this.clickOnImageLocation(subImagePath, recognition_mode, milliSec);
        Thread.sleep(1000);
        this.sendKeys(text);
        utils.hideKeyBoard(grimlockDriver);
    }

    /**
     * Getting the text from image Element
     *
     * @param subImagePath the sub image path to file in String
     *                     <p>recognition_mode set to STRICT as Default
     *                     <p>milliSec set to 15000 as Default
     * @return the Text In String
     */
    public String getTextFromImageLocation(String subImagePath) {
        return getTextFromImageLocation(subImagePath, STRICT);
    }

    /**
     * Getting the text from image Element
     *
     * @param subImagePath     the sub image path to file in String
     * @param recognition_mode recognition mode for Image Recognition
     *                         <p>milliSec set to 15000 as Default
     * @return the Text In String
     */
    public String getTextFromImageLocation(String subImagePath, RECOGNITION_MODE recognition_mode) {
        return getTextFromImageLocation(subImagePath, recognition_mode, DEFAULT_TIME_TO_WAIT);
    }

    /**
     * Getting the text from image Element
     *
     * @param subImagePath the sub image path to file in String
     *                     <p>recognition_mode set to STRICT as Default
     * @param milliSec     wait time in milliSec
     * @return the Text In String
     */
    public String getTextFromImageLocation(String subImagePath, long milliSec) {
        return getTextFromImageLocation(subImagePath, STRICT, milliSec);
    }

    /**
     * Getting the text from image Element
     *
     * @param subImagePath     the sub image path to file in String
     * @param recognition_mode recognition mode for Image Recognition
     * @param milliSec         wait time in milliSec
     * @return the Text In String
     */
    public String getTextFromImageLocation(String subImagePath, RECOGNITION_MODE recognition_mode, long milliSec) {
        this.clickOnImageLocation(subImagePath, recognition_mode, milliSec);
        return grimlockDriver.switchTo().activeElement().getText();

    }

    public Point waitUntilImageLocationFound(String targetImgPath) {
        return waitUntilImageLocationFound(targetImgPath, STRICT, DEFAULT_TIME_TO_WAIT);
    }

    /**
     * Wait Util the Image Will Show In the Screen
     *
     * @param targetImgPath    the sub image path to file in String
     * @param recognition_mode recognition mode for Image Recognition
     *                         <p>milliSec set to 15000 as Default
     * @return Point to The Sub Image
     */
    public Point waitUntilImageLocationFound(String targetImgPath, RECOGNITION_MODE recognition_mode) {
        return waitUntilImageLocationFound(targetImgPath, recognition_mode, DEFAULT_TIME_TO_WAIT);
    }

    /**
     * Wait Util the Image Will Show In the Screen
     *
     * @param targetImgPath    the sub image path to file in String
     * @param recognition_mode recognition mode for Image Recognition
     * @param milliSec         wait time in milliSec
     * @return Point to The Sub Image
     */
    public Point waitUntilImageLocationFound(String targetImgPath, RECOGNITION_MODE recognition_mode, long milliSec) {
        Point point = new Point(0, 0);
        try {
            long timeToEnd = System.currentTimeMillis() + milliSec;
            boolean imageFound = false;
            while (timeNotEnd(timeToEnd) && !imageFound) {
                Thread.sleep(550);
                point = getSubImagePoint(targetImgPath, recognition_mode);
                if (isBiggerThenZero(point)) imageFound = true;
            }
            if (!imageFound)
                Assert.assertTrue(imageFound, "Sub Image Not Found ->" + targetImgPath);
            else
                return point;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return point;
    }

    private boolean timeNotEnd(long endWhileTime) {
        return System.currentTimeMillis() < endWhileTime;
    }

    private Point getSubImagePoint(String targetImgPath, RECOGNITION_MODE recognition_mode) {
        String ScreenShotPath = utils.takeScreenshot(grimlockDriver, targetImgPath);
        Point point = utils.getCoords(grimlockDriver, ScreenShotPath, targetImgPath, recognition_mode);
        return point;
    }

    private boolean isBiggerThenZero(Point point) {
        return point.y > 0 || point.x > 0;
    }

    /**
     * Wait Until Element Is Found
     *
     * @param selectorMethod        Selector Method
     * @param elementIdentification Element Identification
     * @return the Element
     */
    public boolean waitUntilElementFound(SELECTOR_METHOD selectorMethod, String elementIdentification) {
        try {
            findElement(selectorMethod, elementIdentification);
            waitUntilElementFound(this.grimlockElement);
        } catch (Exception e) {
            logger.error("Error :-(");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @return the String of the session Id For Remote Uses
     */
    public String getSession() {
        return ((RemoteWebDriver) grimlockDriver).getSessionId().toString();
    }

    /**
     * Navigate to Url In the Browser
     *
     * @param URL the Url In String
     * @throws Exception throw Exception
     */
    public void navigateToUrl(String URL) throws Exception {
        logger.info("Grimlock Driver Navigate to "+URL);
        this.grimlockDriver.navigate().to(new URL(URL));
    }

    /**
     * move to tab or to the application
     *
     * @param text to the tab or application to move to
     */
    public void moveToTabOrApp(String text) {
        utils.switchTo(grimlockDriver, text);
    }

    public String getWindowName() {
        return grimlockDriver.getWindowHandle();
    }

    /**
     * try for 5 sec to find the element
     *
     * @param ele WebElement
     * @return boolean
     * @throws Exception Exception
     */
    private boolean waitUntilElementFound(WebElement ele) throws Exception {
        try {
            return new WebDriverWait(grimlockDriver, 5).until(driver -> isElementVisible(ele));
        } catch (Exception e) {
            logger.error("Error :-(");
            e.printStackTrace();
        }
        return false;
    }

    private boolean isElementVisible(WebElement ele) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(grimlockDriver, 5);
            element = wait.until(ExpectedConditions.visibilityOf(ele));
            return true;
        } catch (Exception e) {
            logger.error("Error :-(");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Find And Building the Element By given SELECTOR_METHOD
     *
     * @param selectorMethod        Selector Method
     * @param elementIdentification Element Identification
     * @return return the Grimlock Driver After Setting Grimlock Element For Using
     */

    public GrimlockDriver findElement(SELECTOR_METHOD selectorMethod, String elementIdentification) {
        switch (selectorMethod) {
            case XPATH:
                grimlockElement = utils.getElementByXpath(grimlockDriver, elementIdentification);
                break;
            case ELEMENT_ID:
                grimlockElement = utils.getElementById(grimlockDriver, elementIdentification);
                break;
            case CSS:
                grimlockElement = utils.getElementByCssSelector(grimlockDriver, elementIdentification);
                break;
        }
        return this;
    }

    /**
     * Send Keys To Active Element
     *
     * @param text the Text To Send
     */
    public void sendKeys(String text) {
        utils.sendKeys(grimlockDriver, text);
    }
}
