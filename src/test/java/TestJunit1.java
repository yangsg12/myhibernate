package test.java;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestResult;

/**
 * Created by Yang on 2017/2/25.
 */
public class TestJunit1 extends TestResult {
    @Override
    public synchronized void addError(Test test, Throwable t) {
        System.out.println("add error");
        super.addError(test, t);

    }

    @Override
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        System.out.println("add failure");
        super.addFailure(test, t);
    }

    @org.junit.Test
    public void testAdd() {
        System.out.println("test add");
    }

    @Override
    public synchronized void stop() {
        System.out.println("stop ");
        super.stop();
    }
}
