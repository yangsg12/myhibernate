package test.java;

import main.java.MessageUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Yang on 2017/2/25.
 */
public class MessageUtilTest {
    String message = "hello world!";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMsg() {
        message = "new world";
        assertEquals(message, messageUtil.printMsg());
    }
}
