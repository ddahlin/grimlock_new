package GrimlockInitialisation.InitalisationUtils;

import java.util.Map;

public class Xml2Params {


    String[] availableParams = {"os"," os_version"," browser"," browser_version"," web_object_to_test"," device_udid"," device_name"," device_version"," application_path"," application_name"," platform"," is_local"," test_name"," reopen_driver_before_each_test"," ad_type"," is_mobile","network_sniffer","xcode_org_id","browserstack_user_name ","browserstack_key","network_sniffer_port"};
    /**
     * <p>OS ,OS_VERSION,BROWSER,BROWSER_VERSION,WEB_OBJECT_TO_TEST
     * for web testing
     * else set it to false
     */
    public String OS, OS_VERSION, BROWSER, BROWSER_VERSION, WEB_OBJECT_TO_TEST;


    /**
     * <p>DEVICE_UDID,DEVICE_NAME,DEVICE_VERSION,APPLICATION,PLATFORM
     * for mobile testing
     * else set is to false
     */
    public String DEVICE_UDID, DEVICE_NAME, DEVICE_VERSION, APPLICATION_PATH, PLATFORM, APPLICATION_NAME,XCODE_ORG_ID;

    /**
     * <p>EST_NAME,AD_TYPE ,IS_LOCAL,IS_MOBILE,REOPEN_DRIVER_BEFORE_EACH_TEST
     * mandatory for both of the test
     */
    public String TEST_NAME, AD_TYPE;
    public boolean IS_LOCAL, IS_MOBILE, REOPEN_DRIVER_BEFORE_EACH_TEST;

    public String NETWORK_SNIFFER,NETWORK_SNIFFER_PORT,BROWSERSTACK_USER_NAME,BROWSERSTACK_KEY;
    /**
     * <p>the following params separate to 3 group:\n
     * <p>web params (false if is_mobile = True):
     *
     * @param os                             for remote test in browserStack can be : windows|mac - Only if local is false
     * @param os_version                     for remote test in browserStack can be : windows 10 |mac OS - Only if local is false
     * @param browser                        can be : chrome , firefox , safari
     * @param browser_version                can be : chrome version {67.00 to current version} , firefox{} ,safari {}
     * @param web_object_to_test             can be : vast inspector page test
     *                                       <p>mobile params(false if is_mobile = False) :\n
     * @param device_udid                    if it iOS device udid is require
     * @param device_name                    can be : iPhone device or Android device (device name can be found in 'about' in device settings)
     * @param device_version                 can be :  ios version or Android version (device_version name can be found in 'about' in device settings)
     * @param application_path               can be : Jw_Player, IAB_Test_App and more.. for example :/Users/user/Desktop/Jwplayer.ipa
     * @param platform                       can be android or ios
     * @param application_name               the name of the application
     * @param xcode_org_id                   the team xcode Id
     *                                       <p>                                     mandatory params(!!) :
     * @param is_local                       true if is local testing , false if not
     * @param test_name                      the test name
     * @param reopen_driver_before_each_test if true - every round of test the driver will restart
     * @param ad_type                        can be anything : e. pxp , prp , slate and more.
     * @param is_mobile                      if is a mobile testing so it will be true , false for web testing
     * @param network_sniffer                getting the type of networkSniffer
     */
    public Xml2Params(String os, String os_version, String browser, String browser_version, String web_object_to_test
            , String device_udid, String device_name, String device_version, String application_path, String application_name, String platform
            , boolean is_local, String test_name, boolean reopen_driver_before_each_test, String ad_type, boolean is_mobile
            ,String network_sniffer,String xcode_org_id,String browserstack_user_name ,String browserstack_key,String network_sniffer_port) {
//        mobile init params
        this.DEVICE_UDID = device_udid;
        this.DEVICE_NAME = device_name;
        this.DEVICE_VERSION = device_version;
        this.APPLICATION_PATH = application_path;
        this.APPLICATION_NAME = application_name;
        this.PLATFORM = platform;
        this.XCODE_ORG_ID = xcode_org_id;
//        web init params
        this.OS = os;
        this.OS_VERSION = os_version;
        this.BROWSER = browser;
        this.BROWSER_VERSION = browser_version;
        this.WEB_OBJECT_TO_TEST = web_object_to_test;
//        mandatory params
        this.TEST_NAME = test_name;
        this.AD_TYPE = ad_type;
        this.IS_LOCAL = is_local;
        this.IS_MOBILE = is_mobile;
        this.REOPEN_DRIVER_BEFORE_EACH_TEST = reopen_driver_before_each_test;
        this.NETWORK_SNIFFER = network_sniffer;
        this.BROWSERSTACK_USER_NAME = browserstack_user_name;
        this.BROWSERSTACK_KEY = browserstack_key;
        this.NETWORK_SNIFFER_PORT =   network_sniffer_port;

    }

    public Xml2Params (Map params){

        this.DEVICE_UDID = params.get("device_udid").toString();
        this.DEVICE_NAME = params.get("device_name").toString();
        this.DEVICE_VERSION = params.get("device_version").toString();
        this.APPLICATION_PATH = params.get("application_path").toString();
        this.APPLICATION_NAME = params.get("application_name").toString();
        this.PLATFORM = params.get("platform").toString();
        this.XCODE_ORG_ID = params.get("xcode_org_id").toString();
//        web init params
        this.OS = params.get("os").toString();
        this.OS_VERSION = params.get("os_version").toString();
        this.BROWSER = params.get("browser").toString();
        this.BROWSER_VERSION = params.get("browser_version").toString();
        this.WEB_OBJECT_TO_TEST = params.get("web_object_to_test").toString();
//        mandatory params
        this.TEST_NAME = params.get("test_name").toString();
        this.AD_TYPE = params.get("ad_type").toString();
        this.IS_LOCAL = getBoolen(params.get("is_local").toString());
        this.IS_MOBILE = getBoolen(params.get("is_mobile").toString());
        this.REOPEN_DRIVER_BEFORE_EACH_TEST = getBoolen(params.get("reopen_driver_before_each_test").toString());
        this.NETWORK_SNIFFER = params.get("network_sniffer").toString();
        this.BROWSERSTACK_USER_NAME = params.get("browserstack_user_name").toString();
        this.BROWSERSTACK_KEY = params.get("browserstack_key").toString();
        this.NETWORK_SNIFFER_PORT = params.get("network_sniffer_port").toString();
    }
    private boolean getBoolen(String b) {
        if (b.toLowerCase().contains("true"))
            return true;
        else return false;
    }
    public String getAPPLICATION_NAME() {
        return APPLICATION_NAME;
    }

    public String getOS() {
        return OS;
    }

    public String getOS_VERSION() {
        return OS_VERSION;
    }

    public String getBROWSER() {
        return BROWSER;
    }

    public String getBROWSER_VERSION() {
        return BROWSER_VERSION;
    }

    public String getWEB_OBJECT_TO_TEST() {
        return WEB_OBJECT_TO_TEST;
    }

    public String getDEVICE_UDID() {
        return DEVICE_UDID;
    }

    public String getDEVICE_NAME() {
        return DEVICE_NAME;
    }

    public String getDEVICE_VERSION() {
        return DEVICE_VERSION;
    }

    public String getAPPLICATION_PATH() {
        return APPLICATION_PATH;
    }


    public String getPLATFORM() {
        return PLATFORM;
    }

    public String getTEST_NAME() {
        return TEST_NAME;
    }

    public String getAD_TYPE() {
        return AD_TYPE;
    }

    public boolean isIS_LOCAL() {
        return IS_LOCAL;
    }

    public boolean isIS_MOBILE() {
        return IS_MOBILE;
    }

    public boolean isREOPEN_DRIVER_BEFORE_EACH_TEST() {
        return REOPEN_DRIVER_BEFORE_EACH_TEST;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setOS_VERSION(String OS_VERSION) {
        this.OS_VERSION = OS_VERSION;
    }

    public void setBROWSER(String BROWSER) {
        this.BROWSER = BROWSER;
    }

    public void setBROWSER_VERSION(String BROWSER_VERSION) {
        this.BROWSER_VERSION = BROWSER_VERSION;
    }

    public void setWEB_OBJECT_TO_TEST(String WEB_OBJECT_TO_TEST) {
        this.WEB_OBJECT_TO_TEST = WEB_OBJECT_TO_TEST;
    }

    public void setDEVICE_UDID(String DEVICE_UDID) {
        this.DEVICE_UDID = DEVICE_UDID;
    }

    public void setDEVICE_NAME(String DEVICE_NAME) {
        this.DEVICE_NAME = DEVICE_NAME;
    }

    public void setDEVICE_VERSION(String DEVICE_VERSION) {
        this.DEVICE_VERSION = DEVICE_VERSION;
    }

    public void setAPPLICATION_PATH(String APPLICATION_PATH) {
        this.APPLICATION_PATH = APPLICATION_PATH;
    }

    public void setPLATFORM(String PLATFORM) {
        this.PLATFORM = PLATFORM;
    }

    public void setAPPLICATION_NAME(String APPLICATION_NAME) {
        this.APPLICATION_NAME = APPLICATION_NAME;
    }

    public void setXCODE_ORG_ID(String XCODE_ORG_ID) {
        this.XCODE_ORG_ID = XCODE_ORG_ID;
    }

    public void setTEST_NAME(String TEST_NAME) {
        this.TEST_NAME = TEST_NAME;
    }

    public void setAD_TYPE(String AD_TYPE) {
        this.AD_TYPE = AD_TYPE;
    }

    public void setIS_LOCAL(boolean IS_LOCAL) {
        this.IS_LOCAL = IS_LOCAL;
    }

    public void setIS_MOBILE(boolean IS_MOBILE) {
        this.IS_MOBILE = IS_MOBILE;
    }

    public void setREOPEN_DRIVER_BEFORE_EACH_TEST(boolean REOPEN_DRIVER_BEFORE_EACH_TEST) {
        this.REOPEN_DRIVER_BEFORE_EACH_TEST = REOPEN_DRIVER_BEFORE_EACH_TEST;
    }

    public void setNETWORK_SNIFFER(String NETWORK_SNIFFER) {
        this.NETWORK_SNIFFER = NETWORK_SNIFFER;
    }

    public void setNETWORK_SNIFFER_PORT(String NETWORK_SNIFFER_PORT) {
        this.NETWORK_SNIFFER_PORT = NETWORK_SNIFFER_PORT;
    }

    public void setBROWSERSTACK_USER_NAME(String BROWSERSTACK_USER_NAME) {
        this.BROWSERSTACK_USER_NAME = BROWSERSTACK_USER_NAME;
    }

    public void setBROWSERSTACK_KEY(String BROWSERSTACK_KEY) {
        this.BROWSERSTACK_KEY = BROWSERSTACK_KEY;
    }

}
