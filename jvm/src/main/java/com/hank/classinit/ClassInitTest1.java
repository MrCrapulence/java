package com.hank.classinit;

/**
 * @author Hank
 * @date 2022-08-02 00:37
 */
public class ClassInitTest1 {
    static class Father {
        private static int A = 1;

        static {
            A = 2;
        }
    }

    static class Son {
        private static int B = Father.A;
    }

    public static void main(String[] args) {
        // 类初始化时，先加载父类Father，再加载子类Son，所以Father.A会先加载完
        System.out.println(Son.B);  // 结果是2
    }
}
