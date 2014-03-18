package org.stng;

import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.util.List;

/**
 * Created by jk on 14/03/14.
 */
public class StngReporter implements  org.testng.IReporter {

    private static ThreadLocal<ITestResult> m_currentTestResult = new InheritableThreadLocal<ITestResult>();

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

    }
}
