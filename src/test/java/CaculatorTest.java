package test.java;

import main.java.Caculator;
import org.junit.Test;

/**
 * Created by Yang on 2017/2/25.
 */
public class CaculatorTest {
    @Test
    public void evaluedExpress() {
        Caculator caculator = new Caculator();
        int sum = caculator.evaluate("1+2+3");
        assert(6== sum);
    }
}
