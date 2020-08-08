package com.java.test.Util;

/**
 * @Author 邱夏
 * @Date 2020/08/08 22:55
 */
public class ThreadUtils {
    public static void printThread(Thread thread) {
        System.out.println("【ThreadName:" + thread.getName() + "】"+ "Priority=" + thread.getPriority() + "State: " + thread.getState());
        System.out.println("ID" + thread.getId());
    }
}
