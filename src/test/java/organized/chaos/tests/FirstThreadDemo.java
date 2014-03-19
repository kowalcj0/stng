package organized.chaos.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import organized.chaos.LocalDriverManager;
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
        assertTrue(r.nextBoolean());
    }

    private void invokeBrowser(String url) {
        log.info("Thread id = " + Thread.currentThread().getId());
        log.info("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
        log.info("Test executed using = " + LocalDriverManager.getBrowserInfo());
        LocalDriverManager.getDriver().get(url);
    }
}