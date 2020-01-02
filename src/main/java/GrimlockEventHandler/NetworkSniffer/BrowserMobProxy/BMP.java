package GrimlockEventHandler.NetworkSniffer.BrowserMobProxy;

import GrimlockInitialisation.CoreInitialisation.GrimlockBuilder;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

import org.openqa.selenium.Proxy;
import java.net.Inet4Address;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class BMP {
    private BrowserMobProxy proxy;
    public BMP(){
        this.proxy = setupBMP();
        Grimlock.setProxy(proxy);
    }
    public BrowserMobProxy getBMP(){
        return proxy;
    }

    public BrowserMobProxy startBMP(int port){
        proxy.start(port);
        setupHarRecording(proxy);
        return proxy;
    }
    public BrowserMobProxy startBMP(){
        proxy.start(0);
        setupHarRecording(proxy);
        return proxy;
    }

    public Proxy getSeleniumBMP(){
        if(!proxy.isStarted())
            startBMP();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        String hostIp = getHostIp();
        seleniumProxy.setHttpProxy(hostIp+":" + proxy.getPort());
        seleniumProxy.setSslProxy(hostIp+":" + proxy.getPort());
        return seleniumProxy;
    }

    private String getHostIp() {
        String hostIp = "";
        try {
            hostIp = Inet4Address.getLocalHost().getHostAddress();
        } catch (Exception e) {
        }
        return hostIp;
    }

    private void setupHarRecording(BrowserMobProxy BMP) {
        BMP.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        BMP.enableHarCaptureTypes(CaptureType.REQUEST_HEADERS, CaptureType.RESPONSE_HEADERS);
        BMP.newHar("" + BMP.getPort());
    }

    private BrowserMobProxy setupBMP() {
        BrowserMobProxy BMP = new BrowserMobProxyServer();
        BMP.setTrustAllServers(true);
        return BMP;
    }

}
