package com.java.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @AUthor 邱夏
 * 常量池测试
 * JDK6和更早之前的HotSpot虚拟机中，-XX:PermSize=6M -XXMaxPermSize=6M
 * JDK7之后,常量不在方法去了，放在了堆中 -Xmx:6M
 * @Date 2020/07/26
 */
public class ConstantPoolOOM {

    /**
     * String::intern() 介绍
     * 如果常量池中有这个字符串，则返回这个字符串的引用
     * 如果没有，则先添加到字符串中，然后中返回引用
	 * 测试
     */
    public void runTimeConstPoolOOm() {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (false) {
            set.add(String.valueOf(i++).intern());
            System.out.println(i);
			// 测试
        }
    }
}
