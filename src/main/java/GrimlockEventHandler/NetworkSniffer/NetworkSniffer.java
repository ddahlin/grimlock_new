package GrimlockEventHandler.NetworkSniffer;

public interface NetworkSniffer {
    void startNetworkSniffer();

    void startRecording();

    String downloadRecording();

    void stopNetworkSniffer();
}
