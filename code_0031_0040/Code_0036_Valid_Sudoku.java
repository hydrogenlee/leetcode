package leetcode.code_0031_0040;

import java.util.ArrayList;
import java.util.List;

public class Code_0036_Valid_Sudoku {
    public static void main(String[] args) {
        System.out.println(Solution.isValidSudoku(
                new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                })
        );
        System.out.println(Solution.isValidSudoku(
                new char[][]{
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                })
        );
        
    }

    /**
     * 条件：
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     */
    static class Solution {
        public static boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0 || board.length % Math.sqrt(board.length) != 0|| board.length != board[0].length) {
                throw new IllegalArgumentException("Argument board illegal");
            }
            int gridLen = (int) Math.sqrt(board.length);
            boolean[] arr = new boolean[9];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    // 只有第一行计算列
                    if (i == 0) {
                        for (int k = 0; k < board.length; k++) {
                            // 只将'1'-'9'加入list
                            if (board[k][j] != '.') {
                                if (arr[board[k][j] - '0' - 1]) {
                                    return false;
                                } else {
                                    arr[board[k][j] - '0' - 1] = true;
                                }
                            }
                        }
                        arr = new boolean[9];
                    }
                    // 只有第一列计算行
                    if (j == 0) {
                        for (int k = 0; k < board.length; k++) {
                            // 只将'1'-'9'加入list
                            if (board[i][k] != '.') {
                                if (arr[board[i][k] - '0' - 1]) {
                                    return false;
                                } else {
                                    arr[board[i][k] - '0' - 1] = true;
                                }
                            }
                        }
                        arr = new boolean[9];
                    }
                    // 计算grid
                    if (i % gridLen == 0 && j % gridLen == 0) {
                        for (int m = i; m < i + gridLen; m++) {
                            for (int n = j; n < j + gridLen; n++) {
                                // 只将'1'-'9'加入list
                                if (board[m][n] != '.') {
                                    if (arr[board[m][n] - '0' - 1]) {
                                        return false;
                                    } else {
                                        arr[board[m][n] - '0' - 1] = true;
                                    }
                                }
                            }
                        }
                        arr = new boolean[9];
                    }
                }
            }
            return true;
        }
    }
}