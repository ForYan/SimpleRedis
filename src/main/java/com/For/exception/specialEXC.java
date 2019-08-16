package com.For.exception;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Date: 2019/8/5
 * Time: 17:16
 */
public class specialEXC extends Exception{
    public specialEXC() {
    }

    public specialEXC(String message) {
        super(message);
    }

    public specialEXC(String message, Throwable cause) {
        super(message, cause);
    }

    public specialEXC(Throwable cause) {
        super(cause);
    }

    public specialEXC(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
