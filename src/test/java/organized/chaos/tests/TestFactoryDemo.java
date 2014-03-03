package organized.chaos.tests;

import org.testng.annotations.Factory;

/**
 * Created by jk on 03/03/14.
 */
public class TestFactoryDemo {
    @Factory
    public Object[] createInstances() {
        int iterations = 3;
        Object[] result = new Object[iterations];
        for (int i = 0; i < iterations; i++) {
            result[i] = new TestFactoryExampleWebTest(i);
            System.out.println(result[i]);
        }
        return result;
    }

}
