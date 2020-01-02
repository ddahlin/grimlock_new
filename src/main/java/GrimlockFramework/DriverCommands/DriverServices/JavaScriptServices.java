package GrimlockFramework.DriverCommands.DriverServices;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptServices {
    private JavascriptExecutor jsExe  = null;
    public JavaScriptServices(WebDriver driver){
        jsExe = (JavascriptExecutor)driver;
    }
    public Object getDevicePixel(){
        return ( jsExe.executeScript("return window.devicePixelRatio;"));
    }
    public double getWindowScreenWidth(){
        return ((Number)jsExe.executeScript("return window.screen.width;")).doubleValue();
    }
    public double getClientWidth(){
        return ((Number)jsExe.executeScript("return document.getElementsByTagName('body')[0].clientWidth;")).doubleValue();
    }
    public Object getSafariZoomLevel(){
        return jsExe.executeScript("return document.documentElement.clientWidth / window.innerWidth;");
    }
    public Object getChromeZoomLevel(){
        return jsExe.executeScript("return document.documentElement.clientWidth / window.visualViewport.width;");
    }
}
