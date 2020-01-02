package GrimlockInitialisation.Listeners;

import GrimlockInitialisation.InitalisationUtils.Params;
import GrimlockInitialisation.InitalisationUtils.Xml2Params;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.Map;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class InvokedMethodListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
//        if (iInvokedMethod.isConfigurationMethod() && !iInvokedMethod.isTestMethod()
//                && Grimlock != null && Grimlock.grimlockDriver() == null && Grimlock.params() == null && Grimlock.eventService() == null) {
//            Map map = iTestResult.getTestContext().getCurrentXmlTest().getAllParameters();
//            Params params = new Params(map);
//            Grimlock.AddNewDriver(Thread.currentThread().getId(), params);
//        }

        if((((iInvokedMethod.getTestResult().getStatus()==16)||iInvokedMethod.getTestResult().getStatus()==-1)||iInvokedMethod.isConfigurationMethod() && !iInvokedMethod.isTestMethod())
                && Grimlock != null && Grimlock.grimlockDriver() == null && Grimlock.params() == null && Grimlock.eventService() == null){
//            Map map = iTestResult.getTestContext().getCurrentXmlTest().getAllParameters();
            setGrimlockDriver(iTestResult.getTestContext().getCurrentXmlTest().getAllParameters());
        }
    }

    private static void setGrimlockDriver(Map map){
        Params params = new Params(map);
        Grimlock.AddNewDriver(Thread.currentThread().getId(), params);
    }
    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod() && iInvokedMethod.getTestResult().getStatus() == 1 && iInvokedMethod.getTestMethod().isTest())
            if (Grimlock.eventService().networkSniffer != null) {
                {
                    try {
                        Thread.sleep(6000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Grimlock.eventService().validate();
                }
            }

    }
}
