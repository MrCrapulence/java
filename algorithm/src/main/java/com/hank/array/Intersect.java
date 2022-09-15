package com.hank.array;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.Function;

/**
 * @author Hank
 * @date 2022-09-04 11:21
 */
public class Intersect {

    /**
     * 官方解答
     * 使用map记录 nums1 中各元素出现的次数
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        // 为了降低空间复杂度，先遍历长度较短的数组，存入哈希表
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            int count = map.getOrDefault(j, 0) + 1;
            map.put(j, count);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int k : nums2) {
            int count = map.getOrDefault(k, 0);
            if (count > 0) {
                res[index++] = k;
                count--;
                if (count > 0) {
                    map.put(k, count);
                } else {
                    map.remove(k);
                }
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }

    /**
     * 也用到哈希表，但是使用了list转数组
     * list.stream().mapToInt(e -> e).toArray()
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            int count = map.getOrDefault(j, 0) + 1;
            map.put(j, count);
        }

        List<Integer> list = new ArrayList<>();
        for (int k : nums2) {
            if (map.containsKey(k) && map.get(k) > 0) {
                list.add(k);
                map.put(k, map.get(k) - 1);
            }
        }

        return list.stream().mapToInt(e -> e).toArray();
    }

    /**
     * 官方解法：双指针
     * <br>
     * 首先对两个数组进行排序，然后使用两个指针遍历两个数组。<br>
     * 初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。
     */
    public static int[] intersect3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index1 = 0, index2 = 0, index = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                res[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3}, nums2 = {2, 2, 2};
        System.out.println(JSON.toJSONString(intersect3(nums1, nums2)));
    }

}
