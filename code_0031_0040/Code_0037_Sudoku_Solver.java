package leetcode.code_0031_0040;

public class Code_0037_Sudoku_Solver {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        Solution.solveSudoku(board);
        for (char[] aBoard : board) {
            for (char ch : aBoard) {
                System.out.printf(ch + " ");
            }
            System.out.println();
        }

        /*  结果
            5 3 4 6 7 8 9 1 2
            6 7 2 1 9 5 3 4 8
            1 9 8 3 4 2 5 6 7
            8 5 9 7 6 1 4 2 3
            4 2 6 8 5 3 7 9 1
            7 1 3 9 2 4 8 5 6
            9 6 1 5 3 7 2 8 4
            2 8 7 4 1 9 6 3 5
            3 4 5 2 8 6 1 7 9
         */
    }

    // 使用dfs的方法，也就是我先填入一下数字，然后判断，符合条件则继续往下进行
    // 如果不符合条件，则回溯（backtracking），一直找到一个符合条件的算法
    private static class Solution {
        public static void solveSudoku(char[][] board) {
            if (board == null || board.length == 0 || board.length % Math.sqrt(board.length) != 0 || board.length != board[0].length) {
                throw new IllegalArgumentException("Argument board is illegal");
            }
            solve(board);
        }
        private static boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 如果是'.'，就是我们需要填的数
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, i, j, c)) {
                                board[i][j] = c;
                                if (solve(board)){
                                    return true;
                                } else {
                                    // 重新改为未填数状态
                                    board[i][j] = '.';
                                }
                            }
                        }
                        // 说明当前位置无论填什么数都不正确，因此回溯
                        return false;
                    }
                }
            }
            // 全填满了
            return true;
        }

        private static boolean isValid(char[][] board, int row, int col, char c) {
            int cornerRow = 3 * (row / 3);
            int cornerCol = 3 * (col / 3);
            for (int i = 0; i < board.length; i++) {
                // 验证行是否符合要求
                if (i != col && board[row][i] == c) {
                    return false;
                }
                // 验证列是否符合要求
                if (i != row && board[i][col] == c) {
                    return false;
                }
                // 验证小方格是否符合要求
                if (cornerRow + i / 3 != row && cornerCol + i % 3 != col && board[cornerRow + i / 3][cornerCol + i % 3] == c) {
                    return false;
                }
            }
            return true;
        }
    }
}
