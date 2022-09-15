package com.hank.dynamic.programming;

/**
 * @author Hank
 * @date 2022-08-29 18:28
 */
public class MinimumClimbStairs {

    /**
     * 使用最小花费爬楼梯
     * 数组的每个索引作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i] (索引从0开始)。
     * <p>
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * <p>
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     */
    public static int minimumClimbStairs(int[] items) {
        int n = items.length;
        int res0 = items[0];
        int res1 = items[1];

        for (int i = 2; i < n; i++) {
            int temp = res1;
            // 需要反复执行的子子问题部分
            res1 = Math.min(res0, res1) + items[i];
            res0 = temp;
        }
        return Math.min(res0, res1);
    }

    public static void main(String[] args) {
        int[] items = {1, 100, 1, 1, 2, 100, 1, 100, 1};
        int res = minimumClimbStairs(items);
        System.out.println(res);
    }

}
