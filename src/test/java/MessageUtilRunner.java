package test.java;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Yang on 2017/2/25.
 */
public class MessageUtilRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MessageUtilTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
