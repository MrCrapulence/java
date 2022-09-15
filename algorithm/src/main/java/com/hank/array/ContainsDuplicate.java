package com.hank.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hank
 * @date 2022-09-03 16:14
 */
public class ContainsDuplicate {

    /**
     * 先排序，排序后的相同元素一定处于相邻元素
     */
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 自己想出来的
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return nums.length != set.size();
    }

    /**
     * 官方的解法（性能及内存均较好）
     * <br>
     * 使用HashSet方法：boolean add(E e); 返回的布尔值，无需遍历完整个数组
     */
    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(containsDuplicate3(nums));
    }
}
