package dp.practice;

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
        if (t % 2 == 1) {
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
}
