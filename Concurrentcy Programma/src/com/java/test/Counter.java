package com.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 邱夏
 * 线程安全的计数代码
 * @Date 2020/07/25
 */
public class Counter {
    final static int THREAD_COUNT = 600;
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    // 主函数
    public static void CounterTest() {
        final Counter cas = new Counter();
        List<Thread> threadList = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= THREAD_COUNT; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    cas.count();
                    cas.safeCount();
                }
            });
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        // 等待所有线程执行
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private void count() {
        i = i + 1;
    }

    private void safeCount() {
        while (true) {
            int i = atomicI.get();
            boolean result = atomicI.compareAndSet(i, ++i);
            if (result) {
                break;
            }
        }
    }

}
