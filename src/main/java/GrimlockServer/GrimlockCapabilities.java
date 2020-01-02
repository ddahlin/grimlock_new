package GrimlockServer;

import GrimlockEventHandler.NetworkSniffer.BrowserMobProxy.BMP;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class GrimlockCapabilities {
    private DesiredCapabilities capabilities;

    public GrimlockCapabilities() {
        capabilities = new DesiredCapabilities();
    }

    private boolean isCapabilities(String capabilitiesName) {
        if (capabilitiesName.isEmpty() || capabilitiesName.toLowerCase().contains("false"))
            return false;
        else
            return true;
    }

    public DesiredCapabilities getLocalMobileCapabilities() {
        if (Grimlock.params().Application !=null) {
            addLocalApplicationPath(Grimlock.params().getApplication("application_path"));
        } else {
            addLocalBrowserApplication();
        }
        if (Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp")) {
            BMP bmp = new BMP();
            if(Grimlock.params().getNetworkSniffer("port")=="false") bmp.startBMP();
            else bmp.startBMP(Integer.parseInt(Grimlock.params().getNetworkSniffer("port")));
            capabilities.setCapability(CapabilityType.PROXY, bmp.getSeleniumBMP());
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        }
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Grimlock.params().Device.get("device_name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Grimlock.params().Device.get("platform"));
        capabilities.setCapability(MobileCapabilityType.UDID, Grimlock.params().Device.get("udid"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Grimlock.params().Device.get("device_version"));
        if (Grimlock.params().Device.get("platform").toString().toLowerCase().contains("ios")) {
            addIosDeviceCapabilites();
        } else {
            addAndroidDeviceCapabilites();
        }
        return capabilities;
    }

    private void addAndroidDeviceCapabilites() {
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("disableWindowAnimation", true);
        if (!capabilities.getBrowserName().isEmpty())
            capabilities.setCapability("nativeWebScreenshot", true);
    }

    private void addIosDeviceCapabilites() {
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability("xcodeOrgId", Grimlock.params().getDevice("xcode_org_id"));
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("updatedWDABundleId", "com.benrichAxe.WebDriverAgentRunner");
        capabilities.setCapability("wdaLaunchTimeout", "999999999");
        capabilities.setCapability("wdaConnectionTimeout", "999999999");
        capabilities.setCapability("screenshotQuality", "0");
        capabilities.setCapability("sendKeyStrategy", "oneByOne");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("useNewWDA", true);
        capabilities.setCapability("startIWDP", true);
        if (!capabilities.getBrowserName().isEmpty())
            capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
    }

    private void addLocalBrowserApplication() {
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, Grimlock.params().getWebsite("browser"));
        capabilities.setCapability(MobileCapabilityType.BROWSER_VERSION, Grimlock.params().getWebsite("browser_version"));
    }

    private void addLocalApplicationPath(String pathToApp) {
        File file = new File(pathToApp);
        if (file.isAbsolute())
            capabilities.setCapability(MobileCapabilityType.APP, Grimlock.params().getApplication("application_path"));
        else {
            if (pathToApp.startsWith("."))
                pathToApp = pathToApp.substring(1);
            capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + pathToApp);
        }
    }


    public DesiredCapabilities getBrowserstakCapabilites() {
        browserstakCapabilites();
//        if (Grimlock.params().IS_MOBILE) {
//            this.capabilities.setCapability("device", Grimlock.params().getDEVICE_NAME());
//            this.capabilities.setCapability("real_mobile", "true");
//            this.capabilities.setCapability("app", Grimlock.params().getAPPLICATION_PATH());
//        } else {
//            this.capabilities.setCapability("os", Grimlock.params().getOS());
//            this.capabilities.setCapability("browser", Grimlock.params().getBROWSER());
//            this.capabilities.setCapability("browserVersion", Grimlock.params().getBROWSER_VERSION());
//        }
        return capabilities;
    }

    private void browserstakCapabilites() {
//        this.capabilities.setCapability("os_version", Grimlock.params().OS_VERSION);
//
//        this.capabilities.setCapability("name", Grimlock.params().getTEST_NAME());
        //this.capabilities.setCapability("browserstack.debug", "true");
       // this.capabilities.setCapability("project", "GrimlockAutomation");
        //this.capabilities.setCapability("webdriver.remote.sessionid", "test1324");
        this.capabilities.setCapability("browserstack.selenium_version", "3.141.59");
        //this.capabilities.setCapability("build", "0.0.1.alpha");
        this.capabilities.setCapability("build", "0.0.1.alpha");
        this.capabilities.setCapability("browser", "Chrome");
        this.capabilities.setCapability("browser_version", "77.0");
        this.capabilities.setCapability("os", "OS X");
        this.capabilities.setCapability("os_version", "High Sierra");
        this.capabilities.setCapability("resolution", "1024x768");
        this.capabilities.setCapability("name", "Bstack-[Java] Sample Test");
        this.capabilities.setCapability("browserstack.debug", "true");
    }


    public ChromeOptions getChromeOptions(BMP bmp, String CHROME_PATH, boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
//        if (Grimlock.params().NETWORK_SNIFFER.toLowerCase().contains("bmp")) {
        if (Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp")) {
            options.setCapability(CapabilityType.PROXY, bmp.getSeleniumBMP());
        }
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        if (isHeadless)
            options.addArguments("--headless");
        return options;
    }

    public FirefoxOptions getFireFoxOptions(BMP bmp, String FIREFOX_PATH, boolean isHeadles) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        if (Grimlock.params().NETWORK_SNIFFER.toLowerCase().contains("bmp")) {
        if (Grimlock.params().getNetworkSniffer("network_sniffer").toLowerCase().contains("bmp")) {

            FirefoxProfile profile1 = new FirefoxProfile();
            profile1.setPreference("network.proxy.http", "localhost");
            profile1.setPreference("network.proxy.http_port", bmp.getBMP().getPort());
            profile1.setPreference("network.proxy.ssl", "localhost");
            profile1.setPreference("network.proxy.ssl_port", bmp.getBMP().getPort());
            profile1.setPreference("network.proxy.type", 1);
            profile1.setPreference("acceptInsecureCerts", true);
            firefoxOptions.setProfile(profile1);
        }
        System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
        if (isHeadles) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            firefoxOptions.setBinary(firefoxBinary);
        }
        return firefoxOptions;
    }

    public void setSafariProxy() {
        try {
            List<String> networkService = getActiveNetworkNames();
            for (int index = 0; index < networkService.size(); index++) {
                processLoader("networksetup -setwebproxy '" + networkService.get(index) + "' 127.0.0.1 " + Grimlock.proxy().getPort());
                processLoader("networksetup -setsecurewebproxy '" + networkService.get(index) + "' 127.0.0.1 " + Grimlock.proxy().getPort());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private List<String> getActiveNetworkNames() throws Exception {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        List<String> networkServiceNames = new ArrayList<>();
        List<String> networkServiceUiName = new ArrayList<>();
        int j = 0;
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            if (networkInterface.getDisplayName().startsWith("en")) {
                networkServiceNames.add(networkInterface.getDisplayName());
                String networkServiceName = "";
                String exe = "networksetup -listnetworkserviceorder | grep " + networkServiceNames.get(j) + " | awk -F':' '{print $2}' | awk -F',' '{print $1}'";
                j++;
                Process p = processLoader(exe);
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((networkServiceName = stdInput.readLine()) != null) {
                    if (networkServiceName.toLowerCase().contains("ip") || networkServiceName.toLowerCase().contains("serial"))
                        continue;
                    else {
                        if (networkServiceName.startsWith(" "))
                            networkServiceName = networkServiceName.substring(1);
                        networkServiceUiName.add(networkServiceName);
                    }
                }
            }
        }
        return networkServiceUiName;
    }

    public void closeSafariProxy() {
        try {
            List<String> networkService = getActiveNetworkNames();
            for (int index = 0; index < networkService.size(); index++) {
                processLoader("networksetup -setwebproxystate " + networkService.get(index) + " off");
                processLoader("networksetup -setsecurewebproxystate " + networkService.get(index) + " off");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Process processLoader(String command) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/bin/sh", "-c", command);
        return processBuilder.start();
    }
}
