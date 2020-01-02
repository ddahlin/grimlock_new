package GrimlockInitialisation.Listeners;

import GrimlockFramework.Utils.SlackTestStatus;
import GrimlockInitialisation.CoreInitialisation.GrimlockApi;
import GrimlockServer.GrimlockCapabilities;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Map;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;


public class TestListener implements ITestListener {
    private final Logger logger = Logger.getLogger(TestListener.class);
    public SlackTestStatus slackTestStatus = new SlackTestStatus();
    private int count = 0;

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        slackTestStatus.postTestStatus(iTestResult,"Passed");
        handleTest(iTestResult.getTestContext().getCurrentXmlTest().getAllParameters());
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        slackTestStatus.postTestStatus(iTestResult,"Failed");
        handleTest(iTestResult.getTestContext().getCurrentXmlTest().getAllParameters());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        count--;
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        handleTest(iTestResult.getTestContext().getCurrentXmlTest().getAllParameters());
    }

    private void handleTest(Map map) {
        Grimlock.deleteThread(Thread.currentThread().getId());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        count = iTestContext.getAllTestMethods().length;
        if (Grimlock == null) Grimlock = new GrimlockApi();
        if (iTestContext.getCurrentXmlTest().getAllParameters().get("network_sniffer").toLowerCase().contains("charles")) {
            Grimlock.eventService().networkSniffer.startRecording();
        }
        if (iTestContext.getCurrentXmlTest().getAllParameters().get("is_mobile").toLowerCase().contains("true")) {
            if (!Grimlock.appiumRunning) {
                killAppium();
                Grimlock.appiumRunning = true;
            }

        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
            if (iTestContext.getCurrentXmlTest().getAllParameters().get("website").toLowerCase().contains("safarilocal")
                    && iTestContext.getCurrentXmlTest().getAllParameters().get("network_sniffer").toLowerCase().contains("website")) {
                GrimlockCapabilities grimlockCapabilities = new GrimlockCapabilities();
                grimlockCapabilities.closeSafariProxy();

        }
    }

    private void killAppium() {
        if (!Grimlock.appiumRunning) {
            try {
                ProcessBuilder process = new ProcessBuilder();
                process.command("/bin/sh", "-c", "killall node").start();
            }catch (Exception e){e.printStackTrace();}
        }
    }



}
