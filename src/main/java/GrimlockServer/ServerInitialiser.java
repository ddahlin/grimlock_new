package GrimlockServer;

import GrimlockEventHandler.NetworkSniffer.BrowserMobProxy.BMP;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class ServerInitialiser {
    private final String FIREFOX_PATH = "./src/main/resources/ChromeDriver/geckodriver2";
    private final String CHROME_PATH = "./src/main/resources/ChromeDriver/chromedriver78";
    private final String defualt_appium_path ="./src/main/resources/Servers/appium";
    private final String defualt_chrome_mobile_path ="./src/main/resources/ChromeDriver/chromedrivermobile";
    private String localHost = "http://localhost:";
    private static final Logger logger = Logger.getLogger(ServerInitialiser.class);

    public AppiumDriver getAppiumDriver() {
        RunAppiumServer(Grimlock.appiumPorts.get(Thread.currentThread().getId()));
        GrimlockCapabilities grimlockCapabilities = new GrimlockCapabilities();
        AppiumDriver<MobileElement> mobileDriver = null;
        try {
            String url = localHost + Grimlock.appiumPorts.get(Thread.currentThread().getId()) + "/wd/hub";
            if (isIos(Grimlock.params().getDevice("platform"))) {
                mobileDriver = new IOSDriver(new URL(url), grimlockCapabilities.getLocalMobileCapabilities());
            } else {
                mobileDriver = new AndroidDriver(new URL(url), grimlockCapabilities.getLocalMobileCapabilities());
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        mobileDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return mobileDriver;
    }

    private void RunAppiumServer(int port) {
        try {
            String AppiumPath = (Grimlock.params().Device.containsKey("appium_path")) ? Grimlock.params().Device.get("appium_path").toString() : defualt_appium_path;
            String ChromeMobilePath;
            if(Grimlock.params().Website==null) ChromeMobilePath = defualt_chrome_mobile_path;
            else ChromeMobilePath = (Grimlock.params().Website.containsKey("driver_path")) ? Grimlock.params().Website.get("driver_path").toString() : defualt_chrome_mobile_path;

            logger.info("start to run appium for port :" + port);
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("/bin/sh", "-c", "node "+AppiumPath+"/node_modules/appium/build/lib/main.js"
                    + " -a 127.0.0.1 -p " + port
                    + " --chromedriver-executable "+ ChromeMobilePath);
            Process runAppium = processBuilder.start();
            int attempts = 3;
            while (attempts > 0) {
                int exitCode = 0;
                try {
                    exitCode = runAppium.exitValue();
                } catch (IllegalThreadStateException e) {
                    Thread.sleep(2000);
                    attempts--;
                }
                if (attempts > 0 && exitCode > 0)
                    throw new Exception("Appium-Server failed to load");
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private boolean isIos(String platform) {
        return platform.toLowerCase().contains("ios");
    }

    public AppiumDriver remoteAppiumServer() {
        GrimlockCapabilities grimlockCapabilities = new GrimlockCapabilities();
        AppiumDriver<MobileElement> mobileDriver = null;
        try {
            if (isIos(Grimlock.params().getDevice("platform"))) {
                mobileDriver = new IOSDriver(new URL(localHost), grimlockCapabilities.getBrowserstakCapabilites());
            } else {
                mobileDriver = new AndroidDriver(new URL(localHost), grimlockCapabilities.getBrowserstakCapabilites());
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        mobileDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return mobileDriver;
    }

    public WebDriver remoteSeleniumServer(String remoteUrl) {
        GrimlockCapabilities grimlockCapabilities = new GrimlockCapabilities();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(remoteUrl), grimlockCapabilities.getBrowserstakCapabilites());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        return driver;
    }

    public WebDriver localSeleniumServer() {
        WebDriver driver = null;
        BMP bmp = runBMProxy();
        String Driver_Path;
        switch (Grimlock.params().getWebsite("browser").toLowerCase()) {
            case "safari":
                GrimlockCapabilities  capabilities = new GrimlockCapabilities();
                capabilities.setSafariProxy();
                bmp.getSeleniumBMP();
                SafariDriverService service = new SafariDriverService.Builder().usingTechnologyPreview(false).build();
                driver = new SafariDriver(service);
                break;
            case "chrome":
                Driver_Path = (Grimlock.params().Website.containsKey("driver_path")) ? Grimlock.params().Website.get("driver_path").toString() : CHROME_PATH;
                driver = new ChromeDriver(new GrimlockCapabilities().getChromeOptions(bmp, Driver_Path, false));
                break;
            case "chrome_headless":
                Driver_Path = (Grimlock.params().Website.containsKey("driver_path")) ? Grimlock.params().Website.get("driver_path").toString() : CHROME_PATH;
                driver = new ChromeDriver(new GrimlockCapabilities().getChromeOptions(bmp, Driver_Path, true));
                break;
            case "firefox":
                Driver_Path = (Grimlock.params().Website.containsKey("driver_path")) ? Grimlock.params().Website.get("driver_path").toString() : FIREFOX_PATH;
                driver = new FirefoxDriver(new GrimlockCapabilities().getFireFoxOptions(bmp, Driver_Path, false));
                break;
            case "firefox_headless":
                Driver_Path = (Grimlock.params().Website.containsKey("driver_path")) ? Grimlock.params().Website.get("driver_path").toString() : FIREFOX_PATH;
                driver = new FirefoxDriver(new GrimlockCapabilities().getFireFoxOptions(bmp, Driver_Path, true));
                break;
        }
        driver.manage().window().maximize();
       // driver.manage().window().fullscreen();
        return driver;
    }

    private BMP runBMProxy() {
        BMP bmp = null;
        if (Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp")) {
            bmp = new BMP();
            bmp.getBMP();
            bmp.startBMP();
        }
        return bmp;
    }

}
