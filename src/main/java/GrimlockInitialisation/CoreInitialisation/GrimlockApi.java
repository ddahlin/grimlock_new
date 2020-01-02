package GrimlockInitialisation.CoreInitialisation;
import GrimlockEventHandler.EventController;
import GrimlockEventHandler.EventHandler.EventValidatorService;
import GrimlockFramework.DriverCommands.GrimlockDriver;
import GrimlockInitialisation.InitalisationUtils.Params;
import net.lightbody.bmp.BrowserMobProxy;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
public class  GrimlockApi {
    private static Map<Long, GrimlockDriver> grimlockDriverPair;
    private static Map<Long, EventValidatorService> eventService;
    private static Map<Long, BrowserMobProxy> proxy;
    private static int appiumPort = 4723;
    private static Map<Long, Params> params;
    public static boolean appiumRunning = false;
    public static Map<Long,Integer> appiumPorts;
    private static final Logger logger = Logger.getLogger(GrimlockApi.class);

    public GrimlockApi() {
        logger.info("Grimlock Is Up !!!");
        this.grimlockDriverPair = new HashMap<>();
        this.eventService = new HashMap<>();
        this.proxy = new HashMap<>();
        this.params = new HashMap<>();
        this.appiumPorts = new HashMap<>();
    }

    public static void AddNewDriver(Long ThreadId, Params params) {
        logger.info("Thread Id "+ThreadId +" Start New Session In Grimlock...");
        setParams(ThreadId, params);
        setEventService(ThreadId);
        setGrimlockDriverPair(ThreadId);

    }

    private static void setEventService(Long ThreadId) {
        if(params().NetworkSniffer!=null){
            logger.info("Setting Event Map For Thread "+ThreadId);
            //EventController eventController = new EventController(params().NetworkSniffer.get("network_sniffer").toString());
            EventController eventController = new EventController(params().getNetworkSniffer("network_sniffer"));
            eventService.put(ThreadId, new EventValidatorService(eventController.getNetworkSniffer()));
        }
        else {
            eventService.put(ThreadId, new EventValidatorService(null));
        }
    }

    private static void setGrimlockDriverPair(Long ThreadI) {
        initAppiumPort(ThreadI);
        grimlockDriverPair.put(ThreadI,new GrimlockBuilder().buildGrimlockDriver() );
        logger.info("Setting Grimlock Driver For Thread "+ThreadI);

    }

    private static void initAppiumPort(Long ThreadI) {
        if(params().IS_MOBILE) {
            appiumPorts.put(ThreadI, appiumPort);
            appiumPort = appiumPort+1;
        }
    }

    private static void setParams(Long ThreadId, Params param) {

        params.put(ThreadId, param);
    }

    public static Params params() {
        return params.get(Thread.currentThread().getId());
    }

    public static EventValidatorService eventService() {
        return eventService.get(Thread.currentThread().getId());
    }

    public static void setProxy(BrowserMobProxy Proxy) {
        logger.info("Setting Proxy for Thread "+Thread.currentThread().getId());
        proxy.put(Thread.currentThread().getId(), Proxy);
    }

    public static void deleteThread(Long thread) {
        logger.info("Deleting Thread "+thread +" From Grimlock.");
        proxy().endHar();
        proxy().stop();
        deleteThreadFromMap(proxy,thread);
        deleteThreadFromMap(params,thread);
        if (grimlockDriverPair.containsKey(thread))
            grimlockDriverPair.get(thread).getDriverFramework().quit();
        deleteThreadFromMap(grimlockDriverPair,thread);
        deleteThreadFromMap(eventService,thread);
    }
    private static void deleteThreadFromMap(Map map,Long ThreadId){
        if(map.containsKey(ThreadId))
            map.remove(ThreadId);
        else
            logger.info("The Thread : '"+ThreadId+"' is not exist");
    }

    public static BrowserMobProxy proxy() {
        return proxy.get(Thread.currentThread().getId());
    }

    public static GrimlockDriver grimlockDriver() {
        return grimlockDriverPair.get(Thread.currentThread().getId());
    }
}
