package com.hank.string;

/**
 * @author Hank
 * @date 2022-09-15 10:13
 * 整数反转：给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 *     tips：整数溢出的处理：通常可以转换为INT_MAX的逆操作
 */
public class Reverse {

    public static int reverse1(int x) {
        char[] chars = String.valueOf(Math.abs(x)).toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = temp;
        }

        String str = String.valueOf(chars);
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (Exception ignored) {
            // ignore
        }

        return x < 0 ? -result : result;
    }

    /**
     * 官方解法：数学推导<br>
     * 思路：记 rev 为翻转后的数字，为完成翻转，我们可以重复「弹出」xx 的末尾数字，将其「推入」rev 的末尾，直至 xx 为 00。
     */
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse1(x));
    }

}
