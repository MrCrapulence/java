package com.hank.stack;

import java.util.Date;

/**
 * @author Hank
 * @date 2022-09-28 23:06
 */
public class LocalVariablesTest {
    private int num;

    public void test() {
        int m = 10;
        num++;
        System.out.println(num);
    }

    public void test1() {
        int m = 10;
        num++;
        double d = 11.1;
        System.out.println(num);
        test();
        Date date = new Date();
    }

    public static void main(String[] args) {
        LocalVariablesTest localVariablesTest = new LocalVariablesTest();
        int num = 1;
        localVariablesTest.test();
    }
}
