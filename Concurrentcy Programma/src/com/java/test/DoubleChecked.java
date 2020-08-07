package com.java.test;

/**
 * @Author 邱夏
 * @Date 2020/08/07 23:55
 */
public class DoubleChecked {
    private static DoubleChecked doubleChecked; // do_1

    /**
     * 双重检查锁定
     * 操作4，
     * @return
     */
    public static DoubleChecked getDoubleChecked() {
        if (doubleChecked == null) { // do_2
            synchronized(DoubleChecked.class) {
                if (doubleChecked == null) { // do_3
                    doubleChecked = new DoubleChecked(); // do_4
                }
            }
        }
        return doubleChecked;
    }


}
