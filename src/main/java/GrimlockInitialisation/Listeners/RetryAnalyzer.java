package GrimlockInitialisation.Listeners;


import GrimlockInitialisation.InitalisationUtils.Params;
import GrimlockInitialisation.InitalisationUtils.Xml2Params;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import static GrimlockInitialisation.CoreInitialisation.InitGrimlock.Grimlock;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final Logger logger = Logger.getLogger(RetryAnalyzer.class);
    int counter = 0;
    int retryLimit = 4;
    /*
     * (non-Javadoc)
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     *
     * This method decides how many times a test needs to be rerun.
     * TestNg will call this method every time a test fails. So we
     * can put some code in here to decide when to rerun the test.
     *
     * Note: This method will return true if a tests needs to be retried
     * and false it not.
     *
     */

    @Override
    public boolean retry(ITestResult result) {
        logger.info("Thread = " + Thread.currentThread().getName() + " is retry");
        if (!result.isSuccess()) {                      //Check if test not succeed
            if (counter < retryLimit) {                            //Check if maxtry count is reached
                Grimlock.deleteThread(Thread.currentThread().getId());
//                Grimlock.AddNewDriver(Thread.currentThread().getId(), new Xml2Params(result.getMethod().getXmlTest().getAllParameters()));
                Grimlock.AddNewDriver(Thread.currentThread().getId(), new Params(result.getMethod().getXmlTest().getAllParameters()));
                counter++;                                     //Increase the maxTry count by 1
                result.setStatus(ITestResult.FAILURE);  //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                result.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}