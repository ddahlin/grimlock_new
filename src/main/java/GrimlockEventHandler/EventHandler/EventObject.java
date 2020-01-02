package GrimlockEventHandler.EventHandler;

/**
 * Event Object Class :
 * this class will hold the event information.
 * the information include the next values:
 * unixTime : that will take the time signature of the event.
 * event : will take the event name.
 * tolerance : will use for checking the range of the assert time.
 */
public class EventObject {
    long unixTime;
    String event;
    int tolerance = 0;

    /**
     * Constructor for event Object.
     * In this constructor we get String of event that needed to be in the logs. and gives to also the time signature
     * in unix time.
     * for the assert we need a tolerance for checking the range of the unix time.
     * the tolerance set to 3 sec as default
     *
     * @param event getting event.
     */
    public EventObject(String event) {
        this.unixTime = (System.currentTimeMillis());
        this.event = event;
        this.tolerance = 3000;
    }

    public EventObject(String event, long unixTime) {
        this.unixTime = unixTime;
        this.event = event;
        this.tolerance = 3000;
    }

    /**
     * Constructor for event Object.
     * In this constructor we get String of event that needed to be in the logs. and gives to also the time signature
     * in unix time.
     * for the assert we need a tolerance for checking the range of the unix time.
     *
     * @param event     setting event
     * @param tolerance setting tolerance
     * @param unixTime setting the event time
     */
    public EventObject(String event, long unixTime, int tolerance) {
        this.unixTime = unixTime;
        this.event = event;
        this.tolerance = tolerance;
    }

    /**
     * @return the unix time in long
     */
    public long getUnixTime() {
        return unixTime;
    }

    /**
     * @return the event name in String
     */
    public String getEvent() {
        return event;
    }

    /**
     * @return the tolerance in int
     */
    public int getTolerance() {
        return tolerance;
    }
}
