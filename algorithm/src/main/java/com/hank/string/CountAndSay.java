package com.hank.string;

/**
 * @author Hank
 * @date 2022-09-29 11:54
 * 外观数列
 * leetcode: https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnpvdm/
 */
public class CountAndSay {
    /**
     * 遍历解法（自己想出）
     */
    public static String countAndSay(int n) {
        String temp = "1";
        for (int i = 0; i < n - 1; i++) {
            temp = next(temp);
        }
        return temp;
    }

    /**
     * 找出规律，递归子公式：S(n) = S(n-1)的描述
     */
    private static String next(String prev) {
        StringBuilder sb = new StringBuilder();
        char temp = prev.charAt(0);
        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            char c = prev.charAt(i);
            if (c == temp) {
                count++;
            } else {
                sb.append(count).append(temp);
                temp = c;
                count = 1;
            }
        }
        sb.append(count).append(temp);

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 16; i++) {
            System.out.println(countAndSay(i));
        }
    }
}
