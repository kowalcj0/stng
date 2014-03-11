package org.stng.jbehave;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import organized.chaos.LocalDriverFactory;
import organized.chaos.LocalDriverManager;
import org.apache.log4j.Logger;


public class LocalJbehaveWebDriverListener implements IInvokedMethodListener {

    static Logger log = Logger.getLogger(LocalJbehaveWebDriverListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            /*
            I think that the problem lies here: method.getTestMethod().getXmlTest() ---->>> this method returns NULL
            Probably because method.getTestMethod() returns a JUnitStories object

            I need to access this parameter here to instantiate a new browser specific WebDriver accordingly

            btw. have a look at the log output:
            2014-03-11 10:50:16,196 [TestNG] INFO  org.stng.jbehave.LocalJbehaveWebDriverListener - BEFORE GETTING THE DRIVER NAME: JUnitStories.run()[pri:0, instance:run(org.stng.jbehave.ModifiedOfficialJBehaveTutorialICanToggleACell)]

            ps. I tried to use: testResult.getParameters() but this method returns no parameters
            I also tried few other test runners/embedders/etc, check the ones in the master branch
            under org.stng.jbehave.notworkingrunners package (I removed them from this branch for clarity)
            */
            log.info("BEFORE GETTING THE DRIVER NAME: " + method.getTestMethod());
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            log.info("CREATING an instance of: " + browserName + " driver!");
            WebDriver driver = LocalDriverFactory.createInstance(browserName);
            LocalDriverManager.setWebDriver(driver);
        } else {
            log.warn("beforeInvocation(): METHOD is NOT a testMethod!!!");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = LocalDriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        } else {
            log.warn("afterInvocation(): METHOD is NOT a testMethod!!!");
        }
    }
}