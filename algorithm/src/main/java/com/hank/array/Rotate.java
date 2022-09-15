package com.hank.array;

import java.util.Arrays;

/**
 * @author Hank
 * @date 2022-09-14 16:12
 */
public class Rotate {

    /**
     * 自己思考的结果：旋转矩阵转换为旋转矩形
     */
    public static void rotate1(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int m = i; m < len - i - 1; m++) {
                int old = matrix[i][m];
                int x = i;
                int y = m;
                for (int j = 0; j < 4; j++) {
                    int tempRow = x;
                    x = y;
                    y = len - tempRow - 1;
                    int temp = matrix[x][y];
                    matrix[x][y] = old;
                    old = temp;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 官方解法：额外矩阵
     */
    public static void rotate2(int[][] matrix) {
        int length = matrix.length;
        int[][] temp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                temp[j][length - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            System.arraycopy(temp[i], 0, matrix[i], 0, length);
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 官方解法：翻转。水平翻转再主对角线翻转
     */
    public static void rotate3(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }


    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotate3(matrix);
    }

}
