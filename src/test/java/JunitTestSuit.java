package test.java;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Created by Yang on 2017/2/25.
 */
public class JunitTestSuit {
    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite(MessageUtilTest.class, TestJunit.class, TestJunitRunner1.class);
        TestResult testResult = new TestResult();
        testSuite.run(testResult);
        System.out.println("Number of test case = " + testResult.runCount());
    }
}
