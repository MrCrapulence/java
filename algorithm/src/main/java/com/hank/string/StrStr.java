package com.hank.string;

/**
 * @author Hank
 * @date 2022-09-28 17:37
 */
public class StrStr {
    /**
     * 暴力解法，时间复杂度 O(m*n)
     */
    public static int strStr1(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        A:
        for (int i = 0; i < h - n + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(j + i) != needle.charAt(j)) {
                    continue A;
                }
            }
            return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr1("sadbutsad", "ad"));
    }
}
