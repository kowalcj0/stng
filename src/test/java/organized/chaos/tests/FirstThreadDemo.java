package organized.chaos.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import organized.chaos.DriverManager;
import java.util.Random;
import static org.junit.Assert.assertTrue;


public class FirstThreadDemo {

    static Logger log = Logger.getLogger(FirstThreadDemo.class);
    
    @Test
    public void testMethod1() {
        invokeBrowser("https://duckduckgo.com/");
    }

    @Test
    public void testMethod2() {
        invokeBrowser("http://www.facebook.com");
        // randomly fail this test
        Random r = new Random();
        assertTrue("Something went wrong: " + DriverManager.getBrowserInfo(), r.nextBoolean());
    }

    private void invokeBrowser(String url) {
        log.info("Thread id = " + Thread.currentThread().getId());
        log.info("Hashcode of webDriver instance = " + DriverManager.getDriver().hashCode());
        log.info("Test executed using = " + DriverManager.getBrowserInfo());
        DriverManager.getDriver().get(url);
    }
}