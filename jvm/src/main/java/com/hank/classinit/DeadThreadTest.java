package com.hank.classinit;

/**
 * @author Hank
 * @date 2022-08-02 00:41
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread thread1 = new Thread(r, "线程1");
        Thread thread2 = new Thread(r, "线程2");
        thread1.start();
        thread2.start();
        // 结果：DeadThread中static代码只加载一次
    }
}

class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while (true) {}
        }
    }
}