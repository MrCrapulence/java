package com.hank.string;

import java.util.Arrays;

/**
 * @author Hank
 * @date 2022-09-15 15:42
 */
public class Palindrome {

    /**
     * 筛选 + 判断
     */
    public static boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        // 移除非字母、数字字符
        char[] chars = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                chars[j++] = c;
            }
        }
        chars = Arrays.copyOf(chars, j);

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 官方解法：双指针
     */
    public static boolean isPalindrome2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(" "));
    }

}
