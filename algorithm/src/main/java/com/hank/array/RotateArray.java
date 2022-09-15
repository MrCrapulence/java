package com.hank.array;

import java.util.Arrays;

/**
 * @author Hank
 * @date 2022-09-01 20:26
 */
public class RotateArray {

    /**
     * 自己想出的方式，数量越大会有性能问题
     */
    public static int[] rotate(int[] nums, int k) {
        k %= nums.length;

        int pre, temp;
        for (int i = 0; i < k; i++) {
            pre = nums[0];
            for (int j = 1; j < nums.length; j++) {
                if (j == nums.length - 1) {
                    nums[0] = nums[j];
                }

                temp = nums[j];
                nums[j] = pre;
                pre = temp;

            }
        }

        return nums;
    }

    /**
     * 通过新增临时数组的方式
     * <br>
     * 重点：旋转后的数组下标 (i + k) % nums.length
     */
    public static int[] rotate2(int[] nums, int k) {
        int length = nums.length;
        int[] temp = new int[length];

        // 旋转后的数组下标 (i + k) % nums.length
        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, length);  // 拷贝数组可以使用此方法

        return nums;
    }

    /**
     * 使用 System.arraycopy
     */
    public static int[] rotate3(int[] nums, int k) {
        int length = nums.length;
        k %= length;

        int[] right = Arrays.copyOfRange(nums, length - k, length);
        System.arraycopy(nums, 0, nums, k, length - k);
        System.arraycopy(right, 0, nums, 0, k);

        return nums;
    }

    /**
     * 反转数组
     */
    public static int[] reverse(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        int[] rotate = rotate2(nums, k);
        System.out.println(Arrays.toString(rotate));

        int[] nums1 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(reverse(nums1)));
    }

}
