package organized.chaos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.BaseTestMethod;

import java.lang.reflect.Field;

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
            String browser = DriverManager.getBrowserInfo();
            try {
                BaseTestMethod bm = (BaseTestMethod)testResult.getMethod();
                Field f = bm.getClass().getSuperclass().getDeclaredField("m_methodName");
                f.setAccessible(true);
                String newTestName = testResult.getTestContext().getCurrentXmlTest().getName() + " - " + bm.getMethodName() + " - " + browser;
                log.info("Renaming test name from: '" + bm.getMethodName() + "' to: '" + newTestName + "'");
                f.set(bm, newTestName);
            } catch (Exception ex) {
                System.out.println("ex" + ex.getMessage());
            } finally {
                WebDriver driver = DriverManager.getDriver();
                if (driver != null) {
                    driver.quit();
                }
            }
        }
        log.info("END: organized.chaos.LocalWebDriverListener.afterInvocation");
    }
}