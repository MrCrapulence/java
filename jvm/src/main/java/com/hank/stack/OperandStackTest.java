package com.hank.stack;

/**
 * @author Hank
 * @date 2022-09-29 20:41
 */
public class OperandStackTest {
    public void testAddOperation() {
        byte i = 15;
        int j = 8;
        int k = i + j;

        int m = 100090009;
    }

    public int getSum() {
        int i = 10;
        int j = 15;
        int k = i + j;
        return k;
    }

    public void testSum() {
        // 获取上一个栈帧返回的结果，并保存在操作数栈中
        int sum = getSum();
        int j = 10;
    }

    /**
     * 关于 i++ 和 ++i 区别的面试题
     */
    public void add() {
        // 第一类
        int i1 = 10;
        i1++;
        int i2 = 10;
        ++i2;

        // 第二类
        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;

        // 第三类
        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;

        // 第四类
        int i9 = 10;
        int i10 = i9++ + ++i9;
    }
}
