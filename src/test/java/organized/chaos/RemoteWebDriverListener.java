package organized.chaos;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.testng.internal.BaseTestMethod;

/**
 * A factory of remote WebDrivers. Based on an example taken from:
 * http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 */
public class RemoteWebDriverListener implements IInvokedMethodListener {

    static Logger log = Logger.getLogger(RemoteWebDriverListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        log.info("BEGINNING: organized.chaos.RemoteWebDriverListener.beforeInvocation");
        if (method.isTestMethod()) {
            log.info("Method " + method.getTestMethod().getMethodName() + " is a testMethod");
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            URL hubURL = null;
            try {
                // get the test suite parameter
                hubURL = new URL(method.getTestMethod().getXmlTest().getParameter("hubURL"));
            } catch (MalformedURLException e) {
                log.error(e);
                e.printStackTrace();
            }
            log.info("Using HUB: " + hubURL + " with: " + browserName );
            WebDriver driver = RemoteDriverFactory.createInstance(hubURL, browserName);
            DriverManager.setWebDriver(driver);
        } else {
            log.warn("METHOD is NOT a testMethod!!!!!");
        }
        log.info("END: organized.chaos.RemoteWebDriverListener.beforeInvocation");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        log.info("BEGINNING: organized.chaos.RemoteWebDriverListener.afterInvocation");
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
        log.info("END: organized.chaos.RemoteWebDriverListener.afterInvocation");
    }
}