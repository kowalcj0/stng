package organized.chaos;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Author: Confusions Personified
 * src: http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 *
 * It's a universal WebDriver manager, it works with local and remote instances of webDriver
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> remoteWebDriver = new ThreadLocal<WebDriver>();
    static Logger log;

    static {
        log = Logger.getLogger(DriverManager.class);
    }

    public static WebDriver getDriver() {
        log.debug("Getting remote driver");
        return remoteWebDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        log.debug("Setting driver");
        remoteWebDriver.set(driver);
    }

    public static String getBrowserInfo(){
        log.debug("Getting browser info");
        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion();
        return String.format("%s v:%s %s", browserName, v, os);
    }
}