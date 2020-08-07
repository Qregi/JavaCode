package com.java.test;

/**
 * @Author 邱夏
 * @Date 2020/08/07 22:55
 */
public class GcTest {

    private static final int ONE_MB = 1024 * 1024;

    /**
     * 测试GC的一些信息，打印参数：-XX:+PrintGCDetails
     */
    public void gcTest() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        int i = 100;
        while (i-- > 0) {
            allocation1 = new byte[1 * ONE_MB];
        }
        allocation1 = new byte[200 * ONE_MB];
        allocation2 = new byte[200 * ONE_MB];
        allocation3 = new byte[200 * ONE_MB];
        allocation4 = new byte[400 * ONE_MB];
    }

}
