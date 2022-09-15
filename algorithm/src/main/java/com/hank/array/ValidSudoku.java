package com.hank.array;

/**
 * @author Hank
 * @date 2022-09-08 11:21
 */
public class ValidSudoku {

    /**
     * 官方解法
     */
    public static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        int[][] rows = new int[len][len];
        int[][] columns = new int[len][len];
        int[][][] subboxes = new int[len / 3][len / 3][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'5', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));

        char c = '9';
        int i = c - '0';    // 结果是整数，且恰好是9，可以用来将char转int，在不装箱的情况下

    }
}
