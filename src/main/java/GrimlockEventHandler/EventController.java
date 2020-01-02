package GrimlockEventHandler;

import GrimlockEventHandler.EventHandler.EventValidatorService;
import GrimlockEventHandler.NetworkSniffer.NetworkSniffer;
import GrimlockEventHandler.NetworkSniffer.NetworkSnifferBuilder;

public class EventController {
    NetworkSnifferBuilder networkSnifferBuilder;
    EventValidatorService eventValidatorService;

    public EventController(String networkSnifferName) {

        networkSnifferBuilder = new NetworkSnifferBuilder(networkSnifferName);
        eventValidatorService = new EventValidatorService(getNetworkSniffer());
    }

    public NetworkSniffer getNetworkSniffer() {
        return networkSnifferBuilder.getNetworkSniffer();
    }

    public EventValidatorService getEventValidatorService() {
        return eventValidatorService;
    }
}
