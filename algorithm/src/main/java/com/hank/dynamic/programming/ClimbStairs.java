package com.hank.dynamic.programming;

/**
 * @author Hank
 * @date 2022-08-29 16:08
 */
public class ClimbStairs {

    /**
     * 爬楼梯问题<br>
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n 楼梯台阶数
     */
    public static int climbStairs(int n) {
        int res = 1;
        int res0 = 1;   // 0级台阶
        int res1 = 1;   // 1级台阶
        for (int i = 2; i <= n; i++) {
            res = res0 + res1;
            res0 = res1;
            res1 = res;
        }

        return res;
    }

    public static int p(int i) {
        if (i == 1) return 1;
        if (i == 2) return 2;

        return p(i - 1) + p(i - 2);
    }

    public static void main(String[] args) {
        int n = 40;
        long start = System.currentTimeMillis();
        int p = p(n);
        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(p);
        int i = climbStairs(n);
        long second = System.currentTimeMillis();
        System.out.println((System.currentTimeMillis() - second) + "ms");
        System.out.println(i);
    }


}
