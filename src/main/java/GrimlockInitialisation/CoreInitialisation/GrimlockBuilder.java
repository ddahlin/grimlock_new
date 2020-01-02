package GrimlockInitialisation.CoreInitialisation;

import GrimlockFramework.DriverCommands.DriverUtils.DesktopWebApp;
import GrimlockFramework.DriverCommands.DriverUtils.MobileNativeUtils;
import GrimlockFramework.DriverCommands.DriverUtils.MobileWebApp;
import GrimlockFramework.DriverCommands.GrimlockDriver;
import GrimlockServer.ServerInitialiser;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class GrimlockBuilder {
    private static final String BROWSER_STACK_LOGIN_URL = "@hub-cloud.browserstack.com/wd/hub";

    public GrimlockDriver buildGrimlockDriver() {
        if (Grimlock.params().IS_MOBILE)
            return setMobileDriver();
        else
            return getWebDriver();
    }

    private GrimlockDriver getWebDriver() {
        WebDriver driver;
        if (Grimlock.params().IS_LOCAL)
            driver = new ServerInitialiser().localSeleniumServer();
        else
            driver = new ServerInitialiser().remoteSeleniumServer(getBrowserStackLoginUrl());
        return new GrimlockDriver(driver, new DesktopWebApp(driver));
    }

    private GrimlockDriver setMobileDriver() {
        AppiumDriver driver = getAppiumDriver();
        if (driver.getCapabilities().getBrowserName().isEmpty())
            return new GrimlockDriver(driver, new MobileNativeUtils(driver));
        else
            return new GrimlockDriver(driver, new MobileWebApp(driver));
    }

    private AppiumDriver getAppiumDriver() {
        if (Grimlock.params().IS_LOCAL)
            return new ServerInitialiser().getAppiumDriver();
        else
            return new ServerInitialiser().remoteAppiumServer();
    }

    private String getBrowserStackLoginUrl() {
        return "https://" + Grimlock.params().getRemote("userName") + ":" + Grimlock.params().getRemote("password") + BROWSER_STACK_LOGIN_URL;
    }


}
