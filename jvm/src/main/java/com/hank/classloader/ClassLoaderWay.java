package com.hank.classloader;

import java.sql.DriverManager;

/**
 * @author Hank
 * @date 2022-09-01 00:11
 * 获取ClassLoader的途径
 */
public class ClassLoaderWay {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader2);
    }
}
