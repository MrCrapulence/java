package com.hank.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hank
 * @date 2022-09-15 10:48
 */
public class FirstUniqChar {

    /**
     * 使用哈希表存储出现次数
     */
    public static int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 哈希表使用数组替代
     */
    public static int firstUniqChar2(String s) {
        int len = s.length();
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;   // char值转换为int，然后作为新的数组下标
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "z";
        int i = firstUniqChar2(s);
        System.out.println(i);
    }

}
