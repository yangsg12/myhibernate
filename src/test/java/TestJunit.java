package test.java;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Yang on 2017/2/25.
 */
public class TestJunit extends TestCase {
    protected double aDouble;
    protected double bDouble;

    @Before
    public void setUp() {
        aDouble = 2.0;
        bDouble = 3.0;
    }

    @Test
    public void testAdd() {
        System.out.println("No of test case = " + this.countTestCases());
        System.out.println("Test case name " + this.getName());

        this.setName("set name!");
        System.out.println("update test case name " + this.getName());

    }

    public void tearDown() {
        System.out.println("tear down");
    }
}
