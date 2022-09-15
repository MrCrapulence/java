package com.hank.array;

import java.util.Arrays;

/**
 * @author Hank
 * @date 2022-09-05 17:16
 */
public class MoveZeroes {

    /**
     * 自己的解法1：冒泡，把0往后挪
     */
    public static int[] moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j + 1];
                    nums[j + 1] = 0;
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 自己的解法2：双指针
     */
    public static int[] moveZeroes2(int[] nums) {
        int i = 0, j = 0, len = nums.length;
        while (i < len && j < len) {
            if (nums[i] != 0) {
                i++;
            } else {
                if (nums[j] != 0 && i < j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                }
                j++;
            }
        }
        return nums;
    }

    /**
     * 官方解法：双指针。将非零元素左移<br>
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * <p>
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     * <p>
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     */
    public static int[] moveZeroes3(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeroes3(nums)));
    }
}
