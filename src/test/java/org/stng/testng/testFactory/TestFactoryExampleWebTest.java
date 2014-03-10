package org.stng.testng.testFactory;

import org.testng.annotations.Test;
import organized.chaos.LocalDriverManager;

/**
 * Created by jk on 03/03/14.
 */
public class TestFactoryExampleWebTest {
    private int m_numberOfTimes;
    public TestFactoryExampleWebTest(int numberOfTimes) {
        m_numberOfTimes = numberOfTimes;
    }

    @Test
    public void testServer() {
        if ( LocalDriverManager.getDriver() != null) {
            LocalDriverManager.getDriver().get("http://google.pl");
        }
        System.out.println("I'm running test: " + m_numberOfTimes);
        for (int i = 0; i < m_numberOfTimes; i++) {
            // access the web page

        }
    }

}
