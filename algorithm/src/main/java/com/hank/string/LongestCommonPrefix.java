package com.hank.string;

/**
 * @author Hank
 * @date 2022-09-29 14:01
 * 最长公共前缀
 * leetcode： https://leetcode.cn/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 */
public class LongestCommonPrefix {
    /**
     * 自己想出：横向扫描
     */
    public static String longestCommonPrefix1(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix1(prefix, strs[i]);
            if (prefix.equals("")) {
                return "";
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix1(String str1, String str2) {
        int n = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            sb.append(str1.charAt(i));
        }

        return sb.toString();
    }

    /**
     * 官方解法：分治法（https://leetcode.cn/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/）
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return longestCommonPrefix2(strs, 0, strs.length - 1);
    }

    public static String longestCommonPrefix2(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix2(strs, start, mid);
            String lcpRight = longestCommonPrefix2(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public static String commonPrefix(String str1, String str2) {
        int index = 0;
        int len = Math.min(str1.length(), str2.length());
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[]{"cir", "ce", "car"}));
    }
}
