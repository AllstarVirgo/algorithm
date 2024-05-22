package dp.practice;

public class CountSubstrings {

    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * <p>
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * <p>
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * <p>
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     */
    public int countSubstrings(String s) {
        final int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int res = 0;
        final char[] chars = s.toCharArray();
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (chars[i] == chars[j]) {
                    if ((i + 1) <= (j - 1)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                }
                if(dp[i][j]){
                    res++;
                }
            }
        }
        return res;
    }
}
