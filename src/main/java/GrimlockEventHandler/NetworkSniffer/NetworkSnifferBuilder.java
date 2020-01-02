package GrimlockEventHandler.NetworkSniffer;

import GrimlockEventHandler.NetworkSniffer.BrowserMobProxy.BrowserMobProxyGL;
import GrimlockEventHandler.NetworkSniffer.Charles.CharlesRecording;

public class NetworkSnifferBuilder {
    NetworkSniffer networkSniffer;

    public NetworkSnifferBuilder(String sniffer) {
        String networkSnifferName = sniffer.toLowerCase();
        switch (networkSnifferName) {
            case ("charles"):
                networkSniffer = new CharlesRecording();
                break;
            case ("bmp"):
                networkSniffer = new BrowserMobProxyGL();
                break;

        }
    }

    public NetworkSniffer getNetworkSniffer() {
        return networkSniffer;
    }
}
