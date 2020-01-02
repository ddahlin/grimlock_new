//package GrimlockServer;
//
//import GrimlockInitialisation.InitalisationUtils.Xml2Params;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.io.File;
//
//import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;
//
//public class CapabilitiesBuilder {
//    public static DesiredCapabilities capabilities;
//
//    CapabilitiesBuilder(DesiredCapabilities capabilities) {
//        this.capabilities = capabilities;
//    }
//
//    public static DesiredCapabilities getCapabilities() {
//        return capabilities;
//    }
//
//    public static class BrwoserstackWebCapabilitiesBuilder {
//        public static DesiredCapabilities capabilities;
//
//        public static DesiredCapabilities getCapabilities() {
//            return capabilities;
//        }
//
//        public BrwoserstackWebCapabilitiesBuilder( ) {
//            this.capabilities = new DesiredCapabilities();
//            this.withOs(Grimlock.params().getOS()).withOsVersion(Grimlock.params().getOS_VERSION()).withBrowser(Grimlock.params().getBROWSER())
//                    .withBrowserVersion(Grimlock.params().getBROWSER_VERSION()).withBrowserStackDebug()
//                    .withProject().withWebdriverRemoteSessionid()
//                    .withBrowserstackSeleniumSersion().withBuild()
//                    .withName(Grimlock.params().getTEST_NAME());
//            if (Grimlock.params().BROWSER.toLowerCase().contains("chrome"))
////                capabilities.setCapability("resolution", "1920x1080");
//                capabilities.setCapability("browserstack.use_w3c", "true");
//
//
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withBrowserStackDebug() {
//            this.capabilities.setCapability("browserstack.debug", "true");
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withProject() {
//            this.capabilities.setCapability("project", "GrimlockAutomation");
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withWebdriverRemoteSessionid() {
//            this.capabilities.setCapability("webdriver.remote.sessionid", "test1324");
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withBrowserstackSeleniumSersion() {
//            this.capabilities.setCapability("browserstack.selenium_version", "3.141.59");
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withBuild() {
//            this.capabilities.setCapability("build", "0.0.1.alpha");
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withName(String caps) {
//            this.capabilities.setCapability("name", caps);
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withOs(String os) {
//            this.capabilities.setCapability("os", os);
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withBrowser(String browser) {
//            this.capabilities.setCapability("browser", browser);
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withBrowserVersion(String browserVersion) {
//            this.capabilities.setCapability("browserVersion", browserVersion);
//            return this;
//        }
//
//        private BrwoserstackWebCapabilitiesBuilder withOsVersion(String os_version) {
//            this.capabilities.setCapability("os_version", os_version);
//            return this;
//        }
//
//        public CapabilitiesBuilder build() {
//            return new CapabilitiesBuilder(this.getCapabilities());
//        }
//    }
//
//    public static class LocalMobileCapabilitiesBuilder {
//        public static DesiredCapabilities capabilities;
//
//        public static DesiredCapabilities getCapabilities() {
//            return capabilities;
//        }
//
//        public LocalMobileCapabilitiesBuilder() {
//            String projectPath = System.getProperty("user.dir");
//            capabilities = new DesiredCapabilities();
//            setMandatory(Grimlock.params(), projectPath);
//            if (Grimlock.params().getPLATFORM().toLowerCase().contains("ios")) {
//                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//                capabilities.setCapability("xcodeOrgId", Grimlock.params().XCODE_ORG_ID);
//                capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//                capabilities.setCapability(MobileCapabilityType.UDID, Grimlock.params().getDEVICE_UDID());
//                capabilities.setCapability("updatedWDABundleId", "com.benrichAxe.WebDriverAgentRunner");
//                capabilities.setCapability("wdaLaunchTimeout", "999999999");
//                capabilities.setCapability("wdaConnectionTimeout", "999999999");
//                capabilities.setCapability("screenshotQuality", "0");
//                capabilities.setCapability("sendKeyStrategy", "oneByOne");
//                capabilities.setCapability("unicodeKeyboard", true);
//                capabilities.setCapability("useNewWDA", true);
//
//                capabilities.setCapability("startIWDP", true);
//                if(!capabilities.getBrowserName().isEmpty())
//                    capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
////                capabilities.setCapability("resetKeyboard", true);
//            } else {
//                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                capabilities.setCapability("unicodeKeyboard", "true");
//
//                capabilities.setCapability("disableWindowAnimation", true);
//                if(!capabilities.getBrowserName().isEmpty())
//                    capabilities.setCapability("nativeWebScreenshot", true);
//            }
//
//            capabilities.setCapability("autoGrantPermissions", "true");
//        }
//
//        private void setMandatory(Xml2Params xml2Params, String projectPath) {
//            String pathToApp = Grimlock.params().getAPPLICATION_PATH();
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Grimlock.params().getDEVICE_NAME());
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Grimlock.params().getPLATFORM().toLowerCase());
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Grimlock.params().getDEVICE_VERSION());
//            if (pathToApp.toLowerCase().startsWith(".")||pathToApp.startsWith("/")) {
//                File file = new File(pathToApp);
//                if (file.isAbsolute())
//                    capabilities.setCapability(MobileCapabilityType.APP, pathToApp);
//                else {
//                    if (pathToApp.startsWith("."))
//                        pathToApp = pathToApp.substring(1);
//                    capabilities.setCapability(MobileCapabilityType.APP, projectPath + pathToApp);
//                }
//            } else {
//                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, Grimlock.params().BROWSER);
////                capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
//                capabilities.setCapability(MobileCapabilityType.BROWSER_VERSION, Grimlock.params().BROWSER_VERSION);
//            }
//        }
//
//        public CapabilitiesBuilder build() {
//            return new CapabilitiesBuilder(this.getCapabilities());
//        }
//    }
//
//
//    public static class BrwoserstackMobileCapabilitiesBuilder {
//        public static DesiredCapabilities capabilities;
//
//        public static DesiredCapabilities getCapabilities() {
//            return capabilities;
//        }
//
//        public BrwoserstackMobileCapabilitiesBuilder() {
//            this.capabilities = new DesiredCapabilities();
//            withDevice(Grimlock.params().getDEVICE_NAME()).withOsVersion(Grimlock.params().getDEVICE_VERSION()).withApp()
//                    .withRealMobile().withBrowserStackDebug()
//                    .withProject().withWebdriverRemoteSessionid()
//                    .withBrowserstackSeleniumSersion().withBuild()
//                    .withName(Grimlock.params().getTEST_NAME());
//
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withBrowserStackDebug() {
//            this.capabilities.setCapability("browserstack.debug", "true");
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withProject() {
//            this.capabilities.setCapability("project", "GrimlockAutomation");
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withWebdriverRemoteSessionid() {
//            this.capabilities.setCapability("webdriver.remote.sessionid", "test1324");
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withBrowserstackSeleniumSersion() {
//            this.capabilities.setCapability("browserstack.selenium_version", "3.14.0");
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withBuild() {
//            this.capabilities.setCapability("build", "0.0.1.alpha");
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withName(String caps) {
//            this.capabilities.setCapability("name", caps);
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withDevice(String device) {
//            this.capabilities.setCapability("device", device);
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withOsVersion(String os_version) {
//            this.capabilities.setCapability("os_version", os_version);
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withRealMobile() {
//            this.capabilities.setCapability("real_mobile", "true");
//            return this;
//        }
//
//        private BrwoserstackMobileCapabilitiesBuilder withApp() {
////        this.capabilities.setCapability("app", "bs://d26812edc41442ddee550224ea3c57b875e17598");
//            this.capabilities.setCapability("app", "bs://0c0fc8839e7d64f5f7dac1e12fb0755a8495ff28");
//            return this;
//        }
//
//        public CapabilitiesBuilder build() {
//            return new CapabilitiesBuilder(this.getCapabilities());
//        }
//    }
//
//
//}
