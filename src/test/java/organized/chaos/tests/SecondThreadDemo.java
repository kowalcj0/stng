package organized.chaos.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import organized.chaos.DriverManager;


public class SecondThreadDemo {

    static Logger log = Logger.getLogger(SecondThreadDemo.class);

    @Test
    public void testMethod3() {
        invokeBrowser("http://www.google.com");
    }

    @Test
    public void testMethod4() {
        invokeBrowser("http://www.google.pl");

    }

    private void invokeBrowser(String url) {
        log.info("Thread id = " + Thread.currentThread().getId());
        log.info("Hashcode of webDriver instance = " + DriverManager.getDriver().hashCode());
        DriverManager.getDriver().get(url);
    }
}