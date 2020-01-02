package GrimlockFramework.DriverCommands.DriverServices;

import GrimlockFramework.ImageRecognition.Tools.ImageActions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static GrimlockFramework.ImageRecognition.Engine.OpenCvSubImageDetection.RECOGNITION_MODE;

public class WebServices {
    private JavaScriptServices javaScriptServices;
    private BufferedImage screenshotImage;
    private ImageActions imageActions;
    private GeneralServices generalServices;

    public WebServices(WebDriver driver) {
        imageActions = new ImageActions();
        javaScriptServices = new JavaScriptServices(driver);
        generalServices = new GeneralServices();
    }

    /**
     * click on the given coords
     *
     * @param pointToClick pointToClick to the sub image on the screen
     */
    public void clickOnWebCoords(WebDriver driver, Point pointToClick, String subImagePath) {
        WebElement element = generalServices.getReferenceOriginElement(driver, subImagePath);
        pointToClick = translateOpenCvCoordsToWebCoords(pointToClick, element);
        new Actions(driver).moveToElement(element, pointToClick.x, pointToClick.y).click().build().perform();
    }

    /**
     * getting the driver capabilities
     *
     * @param driver using driver for getting access to capabilities
     * @return the capabilities of the driver
     */
    public Capabilities getCapabilities(WebDriver driver) {
        return ((RemoteWebDriver) driver).getCapabilities();
    }


    /**
     * Take A screenshot from the device
     *
     * @param driver for make a screen shot
     */
    public String takeWebScreenshot(WebDriver driver, String subImagePath) {
        WebElement element = generalServices.getReferenceOriginElement(driver, subImagePath);
        File screenshot = generalServices.getScreenshotAsFile(driver);
        cropReferenceElementFromScreenshot(driver, element, screenshot);
        return screenshot.getAbsolutePath();
    }

    /**
     * getting the point of the sub image coords
     *
     * @param subImagePath     subImagePath of the sub image file
     * @param recognition_mode the recognition mode of the image recognition
     * @return the center point relative to the bigger image.
     */
    public Point getWebCoords(String screenshotPath, String subImagePath, RECOGNITION_MODE recognition_mode) {
        int pixelRatio = ((Number) javaScriptServices.getDevicePixel()).intValue();
        Point PointToClick = imageActions.getCoords(subImagePath, screenshotPath, recognition_mode, screenshotImage.getWidth());
        PointToClick.setLocation(PointToClick.x / pixelRatio, PointToClick.y / pixelRatio);
        return PointToClick;
    }

    public void sendKeysToWeb(WebDriver grimlockDriver, String keys) {
        new Actions(grimlockDriver).sendKeys(keys).build().perform();
    }

    /**
     * switch to active application
     *
     * @param grimlockDriver grimlock driver for activate the right application or tab
     * @param tabName        the full name of the application
     */
    public void switchTo(WebDriver grimlockDriver, String tabName) {
        grimlockDriver.switchTo().window(tabName);
    }


    private void maximizeWindow(WebDriver driver) {
        driver.manage().window().fullscreen();
    }


    /**
     * translate OpenCv coordinate to Web coordinates
     * It seems the origin of open cv is top left, while the origin of the browser is in the middle.
     * This function translate the coordinates relevant to the given element.
     *
     * @param pointToClick pointToClick to the sub image on the screen
     */
    private Point translateOpenCvCoordsToWebCoords(Point pointToClick, WebElement refElement) {
        return new Point((int) (pointToClick.x - (refElement.getSize().width / 2)), (int) (pointToClick.y - (refElement.getSize().height / 2)));
    }

    private void cropReferenceElementFromScreenshot(WebDriver driver, WebElement elementFrame, File screenshotFile) {
        try {
            driver.switchTo().parentFrame();
            Point elementTopLeftPoint = new Point(elementFrame.getLocation().x, elementFrame.getLocation().y);
            BufferedImage bufferedScreenShotImage = ImageIO.read(screenshotFile);
            int devicePixel = ((Number) javaScriptServices.getDevicePixel()).intValue();
            int widthToCrop = elementFrame.getSize().width * devicePixel;
            int heightToCrop = elementFrame.getSize().height * devicePixel;
            widthToCrop = widthToCrop > bufferedScreenShotImage.getWidth() ? bufferedScreenShotImage.getWidth() : widthToCrop; /* In case the elementFrame goes out of screen */
            heightToCrop = heightToCrop > bufferedScreenShotImage.getHeight() ? bufferedScreenShotImage.getHeight() : heightToCrop;
            screenshotImage = bufferedScreenShotImage.getSubimage(elementTopLeftPoint.x * devicePixel, elementTopLeftPoint.y * devicePixel,
                    widthToCrop, heightToCrop);
            ImageIO.write(screenshotImage, "png", screenshotFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
