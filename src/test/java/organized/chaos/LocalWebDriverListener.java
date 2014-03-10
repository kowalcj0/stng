package organized.chaos;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Author: Confusions Personified
 * src: http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 */public class LocalWebDriverListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("BEGINING: organized.chaos.LocalWebDriverListener.beforeInvocation");
        if (method.isTestMethod()) {
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