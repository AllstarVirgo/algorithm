package graph.practice;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] min = new int[m][n];
        min[0][0] = triangle.get(0).get(0);
        if (m == 1) {
            return triangle.get(0).get(0);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    min[i][j] = min[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    min[i][j] = min[i - 1][j - 1] + triangle.get(i).get(j);
                } else
                    min[i][j] = Math.min(min[i - 1][j] + triangle.get(i).get(j), min[i - 1][j - 1] + triangle.get(i).get(j));
                if (i == m - 1) {
                    res = Math.min(res, min[i][j]);
                }
            }
        }
        return res;
    }
}
