package com.hank.classloader;

/**
 * @author Hank
 * @date 2022-09-01 23:48
 */
public class DelegationTest {
    public static void main(String[] args) {
        String str = new String("hello, jvm");
        System.out.println(str);

        DelegationTest delegationTest = new DelegationTest();
        System.out.println(delegationTest.getClass().getClassLoader());
    }
}
