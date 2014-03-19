package organized.chaos;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Author: Confusions Personified
 * src: http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 */
public class LocalDriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private static Logger log = Logger.getLogger(LocalDriverManager.class);

    public static WebDriver getDriver() {
        log.debug("Getting driver");
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        log.debug("Setting driver");
        webDriver.set(driver);
    }

    public static String getBrowserInfo(){
        log.debug("Getting browser info");
        Capabilities cap = ((RemoteWebDriver) LocalDriverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion().toString();
        return String.format("%s v:%s %s", browserName, v, os);
    }
}