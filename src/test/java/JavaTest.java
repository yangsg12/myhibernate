package test.java;

import junit.framework.TestCase;

/**
 * Created by Yang on 2017/2/25.
 */
public class JavaTest extends TestCase {
    protected  int value1 ,value2;

    protected void Setup() {
        value1 = 3;
        value2 = 2;
    }

    public void testAdd() {
        double result = value1+value2;
        assertTrue(result == 5);
    }
}
