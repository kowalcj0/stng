package org.stng.testng.testFactory;

import org.testng.annotations.Factory;

/**
 * Created by jk on 03/03/14.
 */
public class TestFactoryDemo {
    @Factory
    public Object[] createInstances() {
        int iterations = 2;
        Object[] result = new Object[iterations];
        for (int i = 0; i < iterations; i++) {
            result[i] = new TestFactoryExampleWebTest(i);
            System.out.println("Test factory hash: " + result[i]);
        }
        return result;
    }

}