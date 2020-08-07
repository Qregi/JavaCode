package com.java.test;

/**
 * @AUthor 邱夏
 * @Date 2020/07/25
 */
public class JavaVmStacksOF {

    /**
     * 懒汉，取得时候再加载
     */
    private static JavaVmStacksOF INSTANCE = new JavaVmStacksOF();

    private JavaVmStacksOF() {

    }

    public static JavaVmStacksOF getInstance() {
        return INSTANCE;
    }

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    /**
     * 未设置 26514
     * -Xss200k 2228
     */
    public static void vmStacksOFTest() {
        JavaVmStacksOF oom = JavaVmStacksOF.getInstance();
        try {
            oom.stackLeak();
        } catch (Throwable ex) {
            System.out.println("stack Length: " + oom.stackLength);
            throw ex;
        }
    }

}
