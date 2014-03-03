package organized.chaos.tests;

import org.testng.annotations.Test;
import organized.chaos.LocalDriverManager;

public class FirstThreadDemo {
    @Test
    public void testMethod1() {
        invokeBrowser("https://duckduckgo.com/");
    }

    @Test
    public void testMethod2() {
        invokeBrowser("http://www.facebook.com");
    }

    private void invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
        System.out.println("Test executed using = " + LocalDriverManager.getBrowserInfo());
        LocalDriverManager.getDriver().get(url);
    }
}