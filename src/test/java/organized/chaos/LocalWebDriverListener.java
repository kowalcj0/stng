package organized.chaos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Author: Confusions Personified
 * src: http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 */public class LocalWebDriverListener implements IInvokedMethodListener {

    static Logger log = Logger.getLogger(LocalWebDriverListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        log.info("BEGINNING: organized.chaos.LocalWebDriverListener.beforeInvocation");
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = LocalDriverFactory.createInstance(browserName);
            DriverManager.setWebDriver(driver);
        } else {
            log.warn("METHOD is NOT a testMethod!!!!!");
        }
        log.info("END: organized.chaos.LocalWebDriverListener.beforeInvocation");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        log.info("BEGINNING: organized.chaos.LocalWebDriverListener.afterInvocation");
        if (method.isTestMethod()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
        log.info("END: organized.chaos.LocalWebDriverListener.afterInvocation");
    }
}