package com.hank;

/**
 * @author Hank
 * @date 2022-06-08 23:18
 */
public class StackArchitectureTest {
    private static int a = 1;

    static {
        b = 1;
    }

    private static int b = 10;

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int k = i + j;
        System.out.println(k);
    }
}
