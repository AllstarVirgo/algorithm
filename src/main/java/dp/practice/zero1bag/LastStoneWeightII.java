package dp.practice.zero1bag;

public class LastStoneWeightII {

    /**
     * 01 背包
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = dp[j] | dp[j - stones[i]];
            }
        }
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }

    /**
     * 01 背包
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int t = sum - target;
        if (t < 0 || t % 2 == 1) {
            return 0;
        }
        t = t >> 1;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = t; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[t];
    }

    /**
     * 01 背包
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= getCount(strs[i], '0'); j--) {
                for (int k = n; k >= getCount(strs[i], '1'); k--) {
                    dp[j][k] = Math.max((1 + dp[j - getCount(strs[i], '0')][k - getCount(strs[i], '1')])
                            , dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    private int getCount(String str, char c) {
        final char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == c) {
                count++;
            }
        }
        return count;
    }
}
