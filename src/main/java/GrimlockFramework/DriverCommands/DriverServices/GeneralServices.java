package GrimlockFramework.DriverCommands.DriverServices;

import GrimlockFramework.ImageRecognition.Engine.MetadataUtil;
import org.openqa.selenium.*;

import java.io.File;

public class GeneralServices {
    private final String BASE_ELEMENT_XPATH = "/html/body";

    public GeneralServices(){

    }
    public WebElement getReferenceOriginElement(WebDriver driver, String targetImgPath) {
        WebElement element = null;
        if (targetImgPath != null && !targetImgPath.isEmpty()) {
            String refElementId = MetadataUtil.extractBaseElementIDFromPath(targetImgPath);
            if (!refElementId.isEmpty()) element = driver.findElement(By.id(refElementId));

        }
        if (element == null) element = driver.findElement(By.xpath(BASE_ELEMENT_XPATH));
        return element;
    }
    public File getScreenshotAsFile(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
    public WebElement getElementByXpath(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementById(WebDriver driver, String id) {
        return driver.findElement(By.id(id));

    }
    public WebElement getElementByCssSelector(WebDriver driver, String css) {
        return driver.findElement(By.cssSelector(css));

    }
}
