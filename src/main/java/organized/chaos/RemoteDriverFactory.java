package organized.chaos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * A factory of remote WebDrivers. Based on an example taken from:
 * http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 *
 */
public class RemoteDriverFactory {
    static WebDriver createInstance(URL hubUrl, String browserName) {
        WebDriver driver = null;
        if (browserName.toLowerCase().contains("firefox")) {
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("internet")) {
            DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome")) {
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("safari")) {
            DesiredCapabilities capability = DesiredCapabilities.safari();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("opera")) {
            DesiredCapabilities capability = DesiredCapabilities.opera();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("phantomjs")) {
            DesiredCapabilities capability = DesiredCapabilities.phantomjs();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("android")) {
            DesiredCapabilities capability = DesiredCapabilities.android();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("htmlUnit")) {
            DesiredCapabilities capability = DesiredCapabilities.htmlUnit();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("htmlUnitWithJs")) {
            DesiredCapabilities capability = DesiredCapabilities.htmlUnitWithJs();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("ipad")) {
            DesiredCapabilities capability = DesiredCapabilities.ipad();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        if (browserName.toLowerCase().contains("iphone")) {
            DesiredCapabilities capability = DesiredCapabilities.iphone();
            driver = new RemoteWebDriver(hubUrl, capability);
            return driver;
        }
        return driver;
    }
}
