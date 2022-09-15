package com.hank.array;

/**
 * @author Hank
 * @date 2022-08-30 15:46
 * 删除排序数组中的重复项
 */
public class RemoveDuplicate {

    /**
     * 双指针解决
     * 详情：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
     */
    public static int removeDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }

    /**
     * 重复次数解决
     */
    public static int removeDuplicate2(int[] nums) {
        int count = 0;  // 重复次数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(removeDuplicate2(nums));
    }
}
