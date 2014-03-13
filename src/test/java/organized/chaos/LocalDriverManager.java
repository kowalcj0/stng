package organized.chaos;

import org.openqa.selenium.WebDriver;

/**
 * Author: Confusions Personified
 * src: http://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
 */
public class LocalDriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    // few words on InheritableThreadLocal
    // https://groups.google.com/forum/#!searchin/testng-users/parallel$20report$20overwritten/testng-users/uB17CQc0ELA/lD6xFKvsgq4J
    //private static InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();
    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
} // LocalDriverManager