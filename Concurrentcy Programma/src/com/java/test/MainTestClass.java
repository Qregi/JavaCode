package com.java.test;

/**
 * @AUthor 邱夏
 * @Date 2020/07/25
 * 主函数入口，一些简单的实验类在这里加载
 */
public class MainTestClass {
    public static void main(String[] args) {
        /**
        com.java.test.OOMTest test = com.java.test.OOMTest.INSTANCE;
        test.oomHeapTest();
        **/
        // com.java.test.JavaVmStacksOF.vmStacksOFTest();

        /**
         com.java.test.HappenBeforeTest test = new com.java.test.HappenBeforeTest();
         test.run();
         */


         ConstantPoolOOM constantPoolOOM = new ConstantPoolOOM();
         constantPoolOOM.runTimeConstPoolOOm();


        GcTest gcTest = new GcTest();
        gcTest.gcTest();
    }

}
