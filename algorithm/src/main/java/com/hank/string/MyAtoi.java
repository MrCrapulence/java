package com.hank.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hank
 * @date 2022-09-16 09:42
 */
public class MyAtoi {

    /**
     * 自己的解法：双指针暴力解法
     */
    public static int myAtoi1(String s) {
        int left = 0;
        int right = 0;
        char symbol = '+';
        int symbolCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c) && left == right) {
                if (symbolCount > 0) {
                    break;
                }
                left++;
                right++;
                continue;
            }
            if (left == right && (c == '-' || c == '+')) {
                symbol = c;
                left++;
                right++;
                if (++symbolCount > 1) {
                    return 0;
                }
                continue;
            }
            if (Character.isDigit(c)) {
                right++;
                continue;
            }
            if (!Character.isDigit(c)) {
                break;
            }

        }

        String str = s.substring(left, right);
        if (str.equals("")) {
            return 0;
        }

        int length = str.length();
        int digit = 0;    // 最终得到的数字，判断是否超出限制的通用方式
        for (int i = 0; i < length; i++) {
            int end = str.charAt(i) - '0';
            if (digit > Integer.MAX_VALUE / 10 || (digit == Integer.MAX_VALUE / 10 && end > Integer.MAX_VALUE % 10)) {
                if (symbol == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            digit = digit * 10 + end;
        }

        return symbol == '-' ? digit * -1 : digit;
    }

    /**
     * 官方解法：有限状态自动机
     */
    public static int myAtoi2(String s) {
        StrFiniteAutomation automation = new StrFiniteAutomation();
        for (int i = 0; i < s.length(); i++) {
            automation.get(s.charAt(i));
        }
        return (int) (automation.res * automation.signed);
    }

    static class StrFiniteAutomation {
        // 不要使用双大括号来初始化，有可能导致内存溢出。原因是双大括号其实是匿名内部类处理的，并且持有了外部类的引用。
        // 在 Java 语言中非静态内部类会持有外部类的引用，从而导致 GC 无法回收这部分代码的引用，以至于造成内存溢出。
        private static final Map<String, String[]> automation = new HashMap<>();
        static {
            automation.put("start", new String[]{"start", "signed", "in_number", "end"});
            automation.put("signed", new String[]{"end", "end", "in_number", "end"});
            automation.put("in_number", new String[]{"end", "end", "in_number", "end"});
            automation.put("end", new String[]{"end", "end", "end", "end"});
        }

        // 当前状态
        public String state = "start";

        // 符号
        public int signed = 1;
        // 整数结果
        public long res;

        public void get(char c) {
            String nextState = automation.get(state)[findCharIndex(c)];
            if ("signed".equals(nextState)) {
                if (c == '-') {
                    signed = -1;
                }
            }
            if ("in_number".equals(nextState)) {
                res = res * 10 + c - '0';
                res = signed == 1 ? Math.min(res, Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);
            }
            state = nextState;
        }

        public int findCharIndex(char c) {
            if (Character.isSpaceChar(c)) {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }

    }

    public static void main(String[] args) {
        System.out.println(myAtoi2("   -42"));
    }


}
