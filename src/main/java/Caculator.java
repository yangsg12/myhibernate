package main.java;

/**
 * Created by Yang on 2017/2/25.
 */
public class Caculator {
    public int evaluate(String expression) {
        int sum = 0;
        for (String summand: expression.split("\\+"))
            sum += Integer.valueOf(summand);
        return sum;
    }
}
