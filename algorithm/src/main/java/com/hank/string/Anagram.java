package com.hank.string;

import java.util.Arrays;

/**
 * @author Hank
 * @date 2022-09-15 14:13
 * 字母异位词：每个字符出现的次数都相同
 */
public class Anagram {

    /**
     * 排序后比较
     */
    public static boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        int sLen = sChars.length;
        if (sLen != tChars.length) {
            return false;
        }

        for (int i = 0; i < sLen; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        // Arrays.equals(sChars, tChars); 使用Arrays工具

        return true;
    }

    /**
     * 官方另一种解法：哈希表<br>
     * tips: 由于字符串只包含 2626 个小写字母，因此我们可以维护一个长度为 2626 的频次数组 table，先遍历记录字符串 ss 中字符出现的频次，
     * 然后遍历字符串 tt，减去 table 中对应的频次，如果出现 table[i]<0，则说明 tt 包含一个不在 ss 中的额外字符，返回 false 即可。
     * <br>
     * 进阶问题的核心点在于「字符是离散未知的」，因此我们用哈希表维护对应字符的频次即可
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];  // 如果是Unicode的话，则不能数组代替哈希表，需要用 Map 来处理
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram1("中国人是最厉害的", "最厉害的是中国人"));
    }

}
