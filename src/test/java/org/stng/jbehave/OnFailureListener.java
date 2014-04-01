package org.stng.jbehave;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Use this to grab screenshots etc when test fails
 * http://forums.gradle.org/gradle/topics/testng_results_overwritten_when_running_in_parallel
 * https://github.com/iainrose/vanq-java/blob/master/src/test/java/org/vanq/testng/Listener.java
 */
public class OnFailureListener extends TestListenerAdapter {

    static Logger log = Logger.getLogger(OnFailureListener.class);

    // Takes a screenshot if a @BeforeClass / @BeforeMethod method fails
    @Override
    public void onConfigurationFailure(ITestResult itr) {
        log.info("onConfigurationFailure(): " + itr.getName());
    }

    // Takes a screenshot if a @Test method fails
    @Override
    public void onTestFailure(ITestResult tr) {
        log.info("onTestFailure(): " + tr.getName());
    }

}