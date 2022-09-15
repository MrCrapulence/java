package com.hank.string;

/**
 * @author Hank
 * @date 2022-09-15 10:03
 */
public class ReverseString {

    public static void reverseString1(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }

        System.out.println(s);
    }

    /**
     * 官方解法：双指针
     */
    public static void reverseString2(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString1(s);
    }

}
