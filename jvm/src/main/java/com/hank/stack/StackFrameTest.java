package com.hank.stack;

/**
 * @author Hank
 * @date 2022-09-15 23:45
 */
public class StackFrameTest {
    public void method1() {
        System.out.println("method1开始执行...");
        method2();
        System.out.println("method1结束执行...");
    }

    public int method2() {
        System.out.println("method2开始执行...");
        int i = 10;
        int j = (int) method3();
        System.out.println("method2结束执行...");
        return i + j;
    }

    public double method3() {
        System.out.println("method3开始执行...");
        double j = 20.0d;
        System.out.println("method3结束执行...");
        return j;
    }

    public static void main(String[] args) {
        StackFrameTest stackFrameTest = new StackFrameTest();
        stackFrameTest.method1();
    }

}
