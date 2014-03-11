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

            When I run a test annotated as a TestNG test then I can access this XML "browser" parameter using
            method.getTestMethod().getXmlTest().getLocalParameters().get("browserName")
            If you'd like to check it out for yourself then checkout master branch and run:
            src/test/resources/org.stng.testng.testFactory.xml

            Here's what getXmlTest() returns when I run JBehave test as JUnit one:
            ... BEFORE GETTING THE DRIVER NAME: JUnitStories.run()[pri:0, instance:run(org.stng.jbehave.ModifiedOfficialJBehaveTutorialICanToggleACell)]
            and here's what it returns when I run a test annotated as a TestNG test:
            ... BEFORE GETTING THE DRIVER NAME: TestFactoryExampleWebTest.testServer()[pri:0, instance:org.stng.testng.testFactory.TestFactoryExampleWebTest@38d060ac]

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