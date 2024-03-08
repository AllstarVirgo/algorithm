package dp.practice;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] min = new int[2][n];
        min[0][0] = triangle.get(0).get(0);
        if (m == 1) {
            return triangle.get(0).get(0);
        }
        int cur = 1, prev = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                final int modCur = cur % 2;
                final int modPrev = prev % 2;
                if (j == 0) {
                    min[modCur][j] = min[modPrev][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    min[modCur][j] = min[modPrev][j - 1] + triangle.get(i).get(j);
                } else
                    min[modCur][j] = Math.min(min[modPrev][j], min[modPrev][j - 1]) + +triangle.get(i).get(j);
                if (i == m - 1) {
                    res = Math.min(res, min[modCur][j]);
                }
            }
            cur++;
            prev++;
        }
        return res;
    }
}
