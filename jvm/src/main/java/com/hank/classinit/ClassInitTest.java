package com.hank.classinit;

/**
 * @author Hank
 * @date 2022-08-02 00:20
 */
public class ClassInitTest {
    private static int a = 1;

    static {
        a = 2;
        b = 20;
        System.out.println(a);
        // System.out.println(b);  // 报错，非法的向前引用。可以赋值，但是不可以调用它
    }

    private static int b = 10;  // linking过程的prepare中会先对b赋零值：b = 0； 然后initialization初始化时按顺序赋值： 20 --> 10

    public static void main(String[] args) {
        System.out.println(a);  // 2
        System.out.println(b);  // 10
    }
}
