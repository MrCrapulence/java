package com.hank.dynamic.programming;

import com.alibaba.fastjson.JSON;

/**
 * @author Hank
 * @date 2022-08-31 18:32
 */
public class TradeStock2 {
    public static int tradeStock(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                // 只要后一天比前一天多，就可以选择在后一天卖出，获取利润，这样一直累加利润
                res = res + (prices[i] - prices[i - 1]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 3, 5, 2, 6, 9, 3, 2};
        System.out.println(tradeStock(prices));

        int[][] ss = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(JSON.toJSONString(ss));

    }

}
