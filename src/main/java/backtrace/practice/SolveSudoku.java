package backtrace.practice;

import java.util.HashSet;
import java.util.Set;

public class SolveSudoku {

    private boolean success;

    public void solveSudoku(char[][] board) {
        place(board, 0, 0, new HashSet<>());
    }

    private void place(char[][] board, int row, int column, Set<Character> rowDigital) {
        if (success) {
            return;
        }
        if (column == board.length) {
            place(board, row + 1, 0, new HashSet<>());
        }
        for (int i = column; i < board.length; i++) {
            if (board[row][column] == '.') {
                for (int j = 1; j <= 9; j++) {
                    if (rowDigital.contains(Character.forDigit(j, 10))) {
                        continue;
                    }
                    if (ok(board, row, column, j)) {
                        board[row][column] = Character.forDigit(j, 10);
                        rowDigital.add(board[row][column]);
                        place(board, row, column + 1, rowDigital);
                        board[row][column] = '.';
                        rowDigital.remove(board[row][column]);
                    }
                }
            } else {
                rowDigital.add(board[row][i]);
            }
        }

    }

    private boolean ok(char[][] board, int i, int j, int k) {
        char kCharValue = Character.forDigit(k, 10);
        for (int l = 0; l < board.length; l++) {
            if (board[i][l] == kCharValue || board[l][j] == kCharValue) {
                return false;
            }
        }
        int squareX = (i / board.length) * 3;
        int squareY = (j / board.length) * 3;
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
