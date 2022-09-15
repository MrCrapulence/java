package com.hank.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Hank
 * @date 2022-09-03 16:58
 */
public class SingleNumber {

    public static int singleNumber1(int[] nums) {
        Map<Integer, List<Integer>> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Integer::valueOf));
        for (Integer i : collect.keySet()) {
            if (collect.get(i).size() == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int singleNumber2(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        if (nums[0] != nums[1]) return nums[0];
        return nums[nums.length - 1];
    }

    /**
     * 官方解法（使用异或运算）
     *
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(singleNumber3(nums));
    }

}
