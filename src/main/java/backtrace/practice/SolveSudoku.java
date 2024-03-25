package backtrace.practice;

import java.util.HashSet;
import java.util.Set;

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        place(board);
    }

    /**
     * 返回boolean的搜索方式，可以用来解决只找到一种解的case
     */
    private boolean place(char[][] board) {
        /*
         * 搜索方式是二维的
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (ok(board, i, j, k)) {
                            board[i][j] = k;
                            // 最终返回的结果是true，不会执行返回false的逻辑
                            if (place(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean ok(char[][] board, int i, int j, char kCharValue) {
        for (int l = 0; l < board.length; l++) {
            if (board[i][l] == kCharValue || board[l][j] == kCharValue) {
                return false;
            }
        }
        int squareX = (i / 3) * 3;
        int squareY = (j / 3) * 3;
        Set<Character> set = new HashSet<>();
        for (int l = squareX; l < (squareX + 3); l++) {
            for (int m = squareY; m < (squareY + 3); m++) {
                if (board[l][m] != '.') {
                    if (set.contains(board[l][m])) {
                        return false;
                    }
                    set.add(board[l][m]);
                }
            }
        }
        return true;
    }
}
