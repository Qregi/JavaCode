package com.java.test;

/**
 * @Author 邱夏
 * @Date 2020/08/08 22:22
 */

import com.java.test.Util.SleepUtils;
import com.java.test.Util.ThreadUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程的练习代码
 */
public class ThreadTest {

    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public void process() {
        // 1.线程的一些信息测试
        // multiThread();

        // 2.线程优先级测试
        // threadPriority();

        // 3.线程状态的测试
        // threadState();

        // 4.Daemon 测试
        daemonTest();
    }

    private void multiThread() {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor 和 synchronizer信息, 仅获取线程和线程的堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        // 遍历线程栈信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }

    /**
     * 环境： Windows10， IDEA， JDK：OpenJDK 11
     * 结果：线程输出是按照优先级执行的
     */
    private void threadPriority() {
        List<Job> jobList = new ArrayList<>();
        int i = 10;
        while (i-- > 1) {
            // int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            int priority = i;
            Job job = new Job(priority);
            jobList.add(job);
            Thread thread = new Thread(job, "Thread" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        try {
            TimeUnit.SECONDS.sleep(5);

        }  catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
        notEnd = false;
        for (Job job : jobList) {
            System.out.println("Job Priority:" + job.priority + "Count: " + job.jobCount);
        }
    }

    static class Job implements Runnable {
        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }


    /**
     * 线程的状态测试代码
     */
    private void threadState() {
        Thread thread1 = new Thread(new TimeWaiting(), "TimeWaitingThread");
        Thread thread2 = new Thread(new Waiting(), "Waiting");
        Thread thread3 = new Thread(new Blocked(), "Blocked_1");
        Thread thread4 = new Thread(new Blocked(), "Blocked_2");

        while (true) {
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

            ThreadUtils.printThread(thread1);
            ThreadUtils.printThread(thread2);
            ThreadUtils.printThread(thread3);
            ThreadUtils.printThread(thread4);

            SleepUtils.second(10);
        }
    }

    /**
     * 该线程不断的陷入睡眠
     */
    private static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    /**
     * 该线程在Waiting.class 实例上等待
     */
    private static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 该线程在Blocked实例上加锁后，不会释放该锁
     */
    private static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }


    /**
     * 测试Daemon线程
     */
    private void daemonTest() {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        System.out.println("DameThread start! ");
        thread.start();
    }

    private static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DameThread finally run! ");
            }
        }
    }
}
