package GrimlockEventHandler.NetworkSniffer.BrowserMobProxy;

import GrimlockEventHandler.NetworkSniffer.NetworkSniffer;
public class BrowserMobProxyGL implements NetworkSniffer {

    @Override
    public void startNetworkSniffer() {
    }

    @Override
    public void startRecording() {
//        Grimlock.setProxy(Thread.currentThread(),new BrowserMobProxyServer());
    }

    @Override
    public String downloadRecording() {

//        Har har = Grimlock.proxy().getHar();
//        Grimlock.proxy().endHar();
//        File fos = new File(Thread.currentThread().getName()+Grimlock.grimlockDriver().getSession()+".har");
//        try {
//            har.writeTo(fos);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return fos.getAbsolutePath();
        return "";
    }

    @Override
    public void stopNetworkSniffer() {
//        if(Grimlock.proxy()!=null && Grimlock.proxy().isStarted()&&Grimlock.proxy().getHar().getLog().getEntries().size()>0)
//            Grimlock.proxy().stop();
    }
}
