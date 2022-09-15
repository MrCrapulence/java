package com.hank.stack;

/**
 * @author Hank
 * @date 2022-09-15 23:25
 *
 * <br>
 * 通过设置 -Xss 不同大小观察count打印的变化：
 * 默认情况下：count -> 9209
 * 设置栈的大小：256k count -> 1702
 */
public class StackErrorTest {
    public static int count = 1;

    public static void main(String[] args) {
        System.out.println(count++);
        main(args);
    }
}
