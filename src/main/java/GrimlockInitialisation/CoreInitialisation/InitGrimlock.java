package GrimlockInitialisation.CoreInitialisation;

import GrimlockInitialisation.Listeners.AnnotationTransformer;
import GrimlockInitialisation.Listeners.InvokedMethodListener;
import GrimlockInitialisation.Listeners.SuiteListener;
import GrimlockInitialisation.Listeners.TestListener;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({SuiteListener.class, TestListener.class, InvokedMethodListener.class, AnnotationTransformer.class})

public class InitGrimlock {
    public static GrimlockApi Grimlock;
    private static final Logger logger = Logger.getLogger(InitGrimlock.class);

    @BeforeSuite()
    public void runing() {
        logger.info("Thread "+Thread.currentThread().getName() +"is starting..." );
    }
}
