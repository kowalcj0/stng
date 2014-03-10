package org.stng.jbehave;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import organized.chaos.LocalDriverFactory;
import organized.chaos.LocalDriverManager;

/**
 * This class is a copy of organized.chaos.LocalWebDriverListener
 * I put it here just to use it a new reference point in the org.stng.jbehave.LocalJbehaveWebDriverListener.xml
 * and to experiment with new things etc
 *
 */
public class LocalJbehaveWebDriverListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("BEGINING: organized.chaos.LocalWebDriverListener.beforeInvocation");
        if (method.isTestMethod()) {
            /*
            Problem lies here: method.getTestMethod().getXmlTest() ---->>> this method returns NULL
            Probably because method.getTestMethod() returns a JUnitStories object

            ps. I tried to use: testResult.getParameters() but this method returns no parameters
            */
            System.out.println("BEFORE GETTING THE DRIVER NAME " + method.getTestMethod());
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            System.out.println("!!!!!!!!!!!!!!!!! CREATING an instance of: " + browserName + " driver!");
            WebDriver driver = LocalDriverFactory.createInstance(browserName);
            LocalDriverManager.setWebDriver(driver);
        } else {
            System.out.println("!!!!!!!!!!! METHOD is NOT a testMethod!!!!!");
        }
        System.out.println("END: organized.chaos.LocalWebDriverListener.beforeInvocation");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("BEGINING: organized.chaos.LocalWebDriverListener.afterInvocation");
        if (method.isTestMethod()) {
            WebDriver driver = LocalDriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
        System.out.println("END: organized.chaos.LocalWebDriverListener.afterInvocation");
    }
}