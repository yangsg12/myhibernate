package main.java;

/**
 * Created by Yang on 2017/2/25.
 */
public class MessageUtil {
    private String message;

    public MessageUtil(String message) {
        this.message = message;
    }

    public String printMsg() {
        System.out.println(message);
        return message;
    }
}
