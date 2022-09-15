package com.hank.dynamic.programming;

/**
 * @author Hank
 * @date 2022-08-30 23:37
 */
public class TradeStock1 {

    public static int tradeStock(int[] prices) {
        int min = prices[0];
        int max = 0;    // 设置一个 max 保存 dp[i-1]
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);

            // 反复执行的子子问题部分：p[i] = Math.max(p[i - 1], prices[i] - min);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 2, 5, 6, 4};
        System.out.println(tradeStock(prices));
    }

}
