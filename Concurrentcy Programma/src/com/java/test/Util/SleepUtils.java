package com.java.test.Util;

import java.util.concurrent.TimeUnit;

/**
 * @Author 邱夏
 * @Date 2020/08/08 22:40
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
