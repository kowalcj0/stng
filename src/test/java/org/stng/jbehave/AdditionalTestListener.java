package org.stng.jbehave;

import org.apache.log4j.Logger;
import org.testng.*;
import java.util.Map;

/**
 *
 */
public class AdditionalTestListener implements ITestListener {

    static Logger log = Logger.getLogger(AdditionalTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // follow this thread to add screenshot functionality
        // https://groups.google.com/forum/#!searchin/testng-users/paremeter$20$20testlistener/testng-users/j3N228NPd0c/XjYST44XC-oJ
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        ISuite suite = context.getSuite();
        Map<String, String> params = suite.getXmlSuite().getAllParameters();
        for (Map.Entry<String, String> p : params.entrySet()){
            log.info("Parameter: " + p.getKey() + " = " + p.getValue());
        }
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
