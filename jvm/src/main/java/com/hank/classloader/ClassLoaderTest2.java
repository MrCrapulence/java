package com.hank.classloader;

import sun.misc.Launcher;
import sun.security.ec.SunEC;

import java.net.URL;

/**
 * @author Hank
 * @date 2022-08-31 22:59
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        // 启动类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }

        System.out.println();

        // 扩展类加载器
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(":")) {
            System.out.println(path);
        }

        ClassLoader classLoader = SunEC.class.getClassLoader();
        System.out.println(classLoader);
    }
}
