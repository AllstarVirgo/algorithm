package dp.practice.editdistance;

import java.util.Arrays;

public class MinDistance {

    /**
     * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     * <p>
     * 每步 可以删除任意一个字符串中的一个字符。
     * <p>
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     */
    public int minDistance(String word1, String word2) {
        //1.求最长公共字串
        //2.求该字串和每个串的dif
        //定义：dp[i][j]是w1和w2中分别以i-1和j-1结尾的最长公共字串的长度
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        final char[] w1Chars = word1.toCharArray();
        final char[] w2Chars = word2.toCharArray();
        for (int i = 1; i <= w1Chars.length; i++) {
            for (int j = 1; j <= w2Chars.length; j++) {
                if (w1Chars[i - 1] == w2Chars[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int maxSame = dp[w1Chars.length][w2Chars.length];
        return w1Chars.length + w2Chars.length - 2 * maxSame;
    }

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     */
    public int minDistanceV2(String word1, String word2) {
        final char[] w1Chars = word1.toCharArray();
        final char[] w2Chars = word2.toCharArray();
        int[][] dp = new int[w1Chars.length + 1][w2Chars.length + 1];
        for (int i = 0; i <= w1Chars.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2Chars.length; i++) {
            dp[0][i] = i;
        }
        //定义：dp[i][j]是w1和w2中分别以i-1和j-1结尾的最长公共字串的长度
        for (int i = 1; i <= w1Chars.length; i++) {
            for (int j = 1; j <= w2Chars.length; j++) {
                if (w1Chars[i - 1] == w2Chars[j - 1]) {
                    // 不需要任何处理
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 删除和替换
                    dp[i][j] = Math.min(Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]), 1 + dp[i - 1][j - 1]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[w1Chars.length][w2Chars.length];
    }
}
