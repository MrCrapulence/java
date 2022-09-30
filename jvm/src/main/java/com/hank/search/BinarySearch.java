package com.hank.search;

/**
 * @author Hank
 * @date 2022-09-30 11:10
 * 二分查找（分治法）
 */
public class BinarySearch {
    public static int binarySearch(int[] items, int item) {
        // 先将items按从小到大的顺序排序
        // quickSort(items);
        int min = 0, max = items.length - 1, mid;
        while (min <= max) {
//            mid = (min + max) >> 1;
            mid = (int) Math.floor((min + max) >> 1);
            if (items[mid] < item) {
                min = mid + 1;
            } else if (items[mid] == item) {
                return mid;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{3, 1, 5, 2, 1, 3}, 2));
    }
}
