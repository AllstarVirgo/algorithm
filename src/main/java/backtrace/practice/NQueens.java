package backtrace.practice;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] matrix = new boolean[n][n];
        place(0, matrix, n);
        return result;
    }

    private void place(int row, boolean[][] matrix, int n) {
        if (row == n) {
            List<String> res = from(matrix);
            result.add(res);
            return;
        }
        for (int column = 0; column < n; column++) {
            if (ok(column, row, matrix)) {
                matrix[row][column] = true;
                place(row + 1, matrix, n);
                matrix[row][column] = false;
            }
        }
    }

    private boolean ok(int column, int row, boolean[][] matrix) {
        int columnLeftIndex = column;
        int columnRightIndex = column;
        for (int rowIndex = row; rowIndex >= 0; rowIndex--) {
            if (matrix[rowIndex][column]) {
                return false;
            }
            if (columnLeftIndex > 0 && rowIndex > 0 && matrix[rowIndex - 1][--columnLeftIndex]) {
                return false;
            }
            if (rowIndex > 0 && columnRightIndex < matrix.length - 1 && matrix[rowIndex - 1][++columnRightIndex]) {
                return false;
            }
        }
        return true;
    }

    private List<String> from(boolean[][] matrix) {
        List<String> res = new ArrayList<>(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
