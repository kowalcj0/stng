package organized.chaos.tests;

import org.testng.annotations.Test;
import organized.chaos.LocalDriverManager;

public class SecondThreadDemo {
    @Test
    public void testMethod3() {
        invokeBrowser("http://www.google.com");
    }

    @Test
    public void testMethod4() {
        invokeBrowser("http://www.google.pl");

    }

    private void invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
        LocalDriverManager.getDriver().get(url);
    }
}