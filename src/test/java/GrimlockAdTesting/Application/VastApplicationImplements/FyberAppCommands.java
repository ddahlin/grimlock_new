package GrimlockAdTesting.Application.VastApplicationImplements;

import GrimlockAdTesting.TremorVideoAdType.ImageConstants;
import GrimlockEventHandler.NetworkSniffer.Charles.CharlesParsers;
import java.util.HashMap;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class FyberAppCommands {

    public FyberAppCommands(String s) {
        Grimlock.eventService().setParseEventFunction(CharlesParsers::extractEventName, CharlesParsers::getUnixTimeFromJson);
        //setupAdInApp(s);
    }

    public void setupAdInApp(String xml) {
        try {
            String platformName = Grimlock.params().getDevice("platform");
            if (Grimlock.grimlockDriver().getCapabilities().getBrowserName().isEmpty()) {
                switch (platformName.toLowerCase()) {
                    case "ios":
//                        iosScenario(xml);
                        break;
                    case "android":
                        androidScenario(xml);
                        break;
                }
            }
        }catch (Exception e){}
    }
//    private void iosScenario(String xml) throws InterruptedException {
//        clickOnIosInputFild();
//        sendVastToInputFild(xml);
//        clickOnPlayUIBtn();
//        Thread.sleep(2000);
//        clickOnPlayVideoBtn();
//    }
    private void androidScenario(String xml)throws Exception  {

//        clickOnAllowAllTheTime();
//        clickOnAllow();
        clickOnInterstitial();
        sendPortalInputField(toString());
        SendKeyToMockResponse(xml);
        sendTagUrlInputField();
        sendServerInputField();
        clickOnLoadInterstitial();
        Thread.sleep(12000);
        clickOnShowInterstitial();

    }
//    private void clickOnAllowAllTheTime() {
//        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ANDROID_ALLOWALLTHETIME);
//    }
//    private void clickOnAllow() {
//        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ANDROID_ALLOW);
//    }
    private void clickOnInterstitial() {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ANDROID_INTERSTITIAL_WIDTH_1080_HEIGHT_1920);
    }
    private void sendPortalInputField(String s) {
        try{
        Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.ANDROID_PORTAL,"5431");}catch (Exception e){}
    }

    private void sendServerInputField() {
        try{
            Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.ANDROID_SERVER,"ia-cert");}catch (Exception e){}
    }
    private void sendTagUrlInputField() {
        try{
            Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.ANDROID_TAGURL,"https://cdn2.inner-active.mobi/IA-JSTag/ia-tag-sdk-v3.7.0/ia-tag-sdk.min.js");}catch (Exception e){}
    }
    private String GetMockResponse (String URL){
        HashMap<String, String> url = new HashMap();
        url.put("https://s.tremorvideodsp.com/m/2019/10/9Rd60vic/vast3.xml","1");
        url.put("https://s.tremorvideodsp.com/m/2019/10/vp_qG2k4/vast3.xml","3");
        url.put("https://s.tremorvideodsp.com/m/2019/10/CeZyASos/vast3.xml","5");
        url.put("https://s.tremorvideodsp.com/m/2019/10/JvX2_hv-/vast3.xml","7");
        url.put("https://s.tremorvideodsp.com/m/2019/10/1kElYMJN/vast3.xml","9");
        url.put("https://s.tremorvideodsp.com/m/2019/10/lDovED0N/vast3.xml","11");
        url.put("https://s.tremorvideodsp.com/m/2019/10/IRuishpb/vast3.xml","13");
        url.put("https://s.tremorvideodsp.com/m/2019/10/QvDS2X1I/vast3.xml","15");
        url.put("https://s.tremorvideodsp.com/m/2019/10/_xH3rAS6/vast3.xml","17");
        url.put("https://s.tremorvideodsp.com/m/2019/10/mwuhPqAM/vast3.xml","19");
        url.put("https://s.tremorvideodsp.com/m/2019/10/UKguUlPa/vast3.xml","21");
        url.put("https://s.tremorvideodsp.com/m/2019/10/DEBSLd79/vast3.xml","23");
        url.put("https://s.tremorvideodsp.com/m/2019/10/lIJIRJg5/vast3.xml","25");
        url.put("https://s.tremorvideodsp.com/m/2019/10/jdJLhfq5/vast3.xml","27");
        url.put("https://s.tremorvideodsp.com/m/2019/10/-SQIQbho/vast3.xml","29");
        url.put("https://s.tremorvideodsp.com/m/2019/10/4mU2vPor/vast3.xml","31");
        url.put("https://s.tremorvideodsp.com/m/2019/10/71QFM1FJ/vast3.xml","33");
        url.put("https://s.tremorvideodsp.com/m/2019/10/2TyFevxQ/vast3.xml","35");
        url.put("https://s.tremorvideodsp.com/m/2019/10/x657Ooam/vast3.xml","37");
        url.put("https://s.tremorvideodsp.com/m/2019/10/aWVbjK1N/vast3.xml","39");
        url.put("https://s.tremorvideodsp.com/m/2019/10/FD9rsvll/vast3.xml","41");
        url.put("https://s.tremorvideodsp.com/m/2019/10/XjHlhv0c/vast3.xml","43");
        url.put("https://s.tremorvideodsp.com/m/2019/10/Npw26VYG/vast3.xml","45");
        url.put("https://s.tremorvideodsp.com/m/2019/10/MAhoPfUG/vast3.xml","47");
        url.put("https://s.tremorvideodsp.com/m/2019/10/LS5dD93l/vast3.xml","49");
        url.put("https://s.tremorvideodsp.com/m/2019/10/kZzDaJG4/vast3.xml","51");
        url.put("https://s.tremorvideodsp.com/m/2019/10/PcwaBpFQ/vast3.xml","53");
        url.put("https://s.tremorvideodsp.com/m/2019/10/RsxBvgQV/vast3.xml","55");
        url.put("https://s.tremorvideodsp.com/m/2019/10/2PfW-7cL/vast3.xml","57");
        url.put("https://s.tremorvideodsp.com/m/2019/10/u0o44CR_/vast3.xml","59");
        url.put("https://s.tremorvideodsp.com/m/2019/10/a6LLabGH/vast3.xml","61");
        url.put("https://s.tremorvideodsp.com/m/2019/10/P4LYFqT7/vast3.xml","63");
        url.put("https://s.tremorvideodsp.com/m/2019/10/xpmSYg0H/vast3.xml","65");
        url.put("https://s.tremorvideodsp.com/m/2019/10/__vWYOeE/vast3.xml","67");
        url.put("https://s.tremorvideodsp.com/m/2019/10/pWJTL99P/vast3.xml","69");
        url.put("https://s.tremorvideodsp.com/m/2019/10/e1kh_iBF/vast3.xml","71");
        url.put("https://s.tremorvideodsp.com/m/2019/10/24lYHd37/vast3.xml","73");
        url.put("https://s.tremorvideodsp.com/m/2019/10/93A_-ARJ/vast3.xml","75");
        url.put("https://s.tremorvideodsp.com/m/2019/10/zpxEpt4y/vast3.xml","77");
        url.put("https://s.tremorvideodsp.com/m/2019/10/dtb7pIp4/vast3.xml","79");
        url.put("https://s.tremorvideodsp.com/m/2019/10/QeMJWKGj/vast3.xml","81");
        url.put("https://s.tremorvideodsp.com/m/2019/10/UmpJU6Fo/vast3.xml","83");
        url.put("https://s.tremorvideodsp.com/m/2019/10/V5WeATWE/vast3.xml","85");
        url.put("https://s.tremorvideodsp.com/m/2019/10/W1gf1QQS/vast3.xml","87");
        url.put("https://s.tremorvideodsp.com/m/2019/10/A4BWoovy/vast3.xml","89");
        url.put("https://s.tremorvideodsp.com/m/2019/10/ljJiyIKO/vast3.xml","91");
        url.put("https://s.tremorvideodsp.com/m/2019/10/5ixN3zVX/vast3.xml","93");
        url.put("https://s.tremorvideodsp.com/m/2019/10/YgCfiYNY/vast3.xml","95");
        url.put("https://s.tremorvideodsp.com/m/2019/10/aVt-XcP_/vast3.xml","97");
        url.put("https://s.tremorvideodsp.com/m/2019/10/g8slKtMk/vast3.xml","99");
        url.put("https://s.tremorvideodsp.com/m/2019/10/CBVd0cMb/vast3.xml","101");
        url.put("https://s.tremorvideodsp.com/m/2019/10/4W7oRWRy/vast3.xml","103");
        url.put("https://s.tremorvideodsp.com/m/2019/10/B1R2jCW_/vast3.xml","104");
        url.put("https://s.tremorvideodsp.com/m/2019/10/CgYvx5IL/vast3.xml","105");
        url.put("https://s.tremorvideodsp.com/m/2019/10/kg8pSJJG/vast3.xml","107");
        url.put("https://s.tremorvideodsp.com/m/2019/10/6b20uzHd/vast3.xml","109");
        url.put("https://s.tremorvideodsp.com/m/2019/10/M1dwGvvB/vast3.xml","111");
        url.put("https://s.tremorvideodsp.com/m/2019/10/aRLL0zFJ/vast3.xml","113");
        url.put("https://s.tremorvideodsp.com/m/2019/10/hukYhap2/vast3.xml","115");
        url.put("https://s.tremorvideodsp.com/m/2019/10/5HewL5lu/vast3.xml","117");
        url.put("https://s.tremorvideodsp.com/m/2019/10/WMba3il9/vast3.xml","119");
        url.put("https://s.tremorvideodsp.com/m/2019/10/eb7elPyY/vast3.xml","121");
        url.put("https://s.tremorvideodsp.com/m/2019/10/yPIZp95E/vast3.xml","123");
        url.put("https://s.tremorvideodsp.com/m/2019/10/mN_5GMEU/vast3.xml","125");
        url.put("https://s.tremorvideodsp.com/m/2019/10/HwO_Jqix/vast3.xml","127");
        url.put("https://s.tremorvideodsp.com/m/2019/10/ptqZxZRZ/vast3.xml","129");
        url.put("https://s.tremorvideodsp.com/m/2019/10/-beujvcB/vast3.xml","131");
        return url.get(URL);
    }
    private void clickOnLoadInterstitial() {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ANDROID_LOADINTERSTITIAL);
    }
    private void clickOnShowInterstitial() {
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ANDROID_SHOWINTERSTITIAL);
    }
    private void SendKeyToMockResponse (String xml) { try{
        Grimlock.grimlockDriver().clickOnImageLocation(ImageConstants.ANDROID_MOCKRESPONSE);
        Grimlock.grimlockDriver().sendKeyToImageLocation(ImageConstants.ANDROID_MOCKRESPONSE,"termor_vpaid_"+ GetMockResponse(xml));
    }catch (Exception e){}
    }
}
