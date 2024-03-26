package dp.practice.completebag;

import java.util.List;
import java.util.Objects;

public class WordBreak {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (String s1 : wordDict) {
                final int s1Length = s1.length();
                if (j >= s1Length) {
                    if(Objects.equals(s.substring(j - s1Length, j), s1)) {
                        dp[j] = dp[j - s1Length] | dp[j];
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
