package organized.chaos;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * A factory of remote WebDrivers. Based on an example taken from:
 * http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 */
public class RemoteDriverFactory {

    static Logger log = Logger.getLogger(RemoteDriverFactory.class);

    static WebDriver createInstance(URL hubUrl, String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("internet")) {
            DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("safari")) {
            DesiredCapabilities capability = DesiredCapabilities.safari();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("opera")) {
            DesiredCapabilities capability = DesiredCapabilities.opera();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("phantomjs")) {
            DesiredCapabilities capability = DesiredCapabilities.phantomjs();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("android")) {
            DesiredCapabilities capability = DesiredCapabilities.android();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("htmlUnit")) {
            DesiredCapabilities capability = DesiredCapabilities.htmlUnit();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("htmlUnitWithJs")) {
            DesiredCapabilities capability = DesiredCapabilities.htmlUnitWithJs();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("ipad")) {
            DesiredCapabilities capability = DesiredCapabilities.ipad();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.equalsIgnoreCase("iphone")) {
            DesiredCapabilities capability = DesiredCapabilities.iphone();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        log.info("RemoteDriverFactory created driver for: " + browserName);
        return driver;
    }
}
