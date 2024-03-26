package dp.practice.editdistance;

import java.util.Arrays;

public class NumDistinct {

    /**
     * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10的9次方 + 7 取模。
     * 示例 1：
     * <p>
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     * 解释：
     * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
     * rabbbit
     * rabbbit
     * rabbbit
     */
    public int numDistinct(String s, String t) {
        // 从0到i -1 和j-1的公共字串数量
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        final char[] sChars = s.toCharArray();
        final char[] tChars = t.toCharArray();
        for (int j = 0; j <= tChars.length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= sChars.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sChars.length; i++) {
            for (int j = 1; j <= tChars.length; j++) {
                if (sChars[i - 1] == tChars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[s.length()][t.length()];
    }
}
