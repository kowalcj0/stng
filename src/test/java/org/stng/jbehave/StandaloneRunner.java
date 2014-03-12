package org.stng.jbehave;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jk on 12/03/14.
 * An example how to run TestNG tests pragmatically
 * To run it, uncomment main()
 */
public class StandaloneRunner {

    /*
    public static void main(String[] args){
        //runTestClasses();
        runTestSuite();
    }
*/
    public static void runTestClasses(){
        // define test classes to run
        Class[] classes = new Class[]{ModifiedOfficialJBehaveTutorialICanToggleACell.class};
        // instantiate and configure TestNG object
        TestNG testng = new TestNG();
        testng.setJUnit(true);
        testng.setParallel("tests");
        testng.setThreadCount(2);
        // add listener
        testng.addListener(new LocalJbehaveWebDriverListener());
        // add test classes for execution
        testng.setTestClasses(classes);
        // run tests
        testng.run();
    }

    public static void runTestSuite(){
        List<XmlSuite> suites = getTestSuite();
        TestNG testng = new TestNG();
        testng.setJUnit(true);
        testng.setParallel("tests");
        testng.setThreadCount(2);
        // add listener
        testng.addListener(new LocalJbehaveWebDriverListener());
        testng.setXmlSuites(suites);
        testng.run();
    }

    public static List<XmlSuite> getTestSuite(){
        XmlSuite suite = new XmlSuite();
        suite.setName("SeleniumJBeahveSuite");

        // create and configure test no 1
        XmlTest testNo1 = new XmlTest(suite);
        testNo1.setName("Test on FF");
        Map<String, String> testNo1Params = new HashMap<String, String>();
        testNo1Params.put("browserName","firefox");
        testNo1.setParameters(testNo1Params);

        // create and configure test no 2
        XmlTest testNo2 = new XmlTest(suite);
        testNo1.setName("Test on Chrome");
        Map<String, String> testNo2Params = new HashMap<String, String>();
        testNo1Params.put("browserName","chrome");
        testNo1.setParameters(testNo2Params);


        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("org.stng.jbehave.ModifiedOfficialJBehaveTutorialICanToggleACell"));
        classes.add(new XmlClass("org.stng.jbehave.ModifiedOfficialJBehaveTutorialICanToggleACell"));
        testNo1.setXmlClasses(classes);
        testNo2.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        return suites;
    }

}
