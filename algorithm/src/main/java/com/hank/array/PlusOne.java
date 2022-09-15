package com.hank.array;

import java.util.Arrays;

/**
 * @author Hank
 * @date 2022-09-05 15:32
 */
public class PlusOne {

    /**
     * 自己思考后的结果
     */
    public static int[] plusOne1(int[] digits) {
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i] + temp;
            if (n == 10) {
                temp = 1;
                digits[i] = 0;
                if (i == 0) {
                    // 99..99 + 1 = 100..00 数组扩容
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    return res;
                }
            } else {
                digits[i] = n;
                temp = 0;
            }
        }

        return digits;
    }

    /**
     * 题友解答（个人认为比官方解答要好）<br>
     */
    public static int[] plusOne2(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] digits = {0};
        int[] res = plusOne2(digits);
        System.out.println(Arrays.toString(res));
    }

}
