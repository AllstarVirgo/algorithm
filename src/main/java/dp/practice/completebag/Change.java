package dp.practice.completebag;

import java.util.Arrays;

public class Change {

    /**
     * 针对选择某1种面额，计算可能性，因此不会出现重复计算的问题
     * <p>
     * 计算并返回可以凑成总金额所有可能的硬币个数
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    /**
     * change for loop
     * 假定有两种面额1，2，对于金额3，计算时
     * dp[1] = dp[2]
     * dp[2] = dp[1]
     * 会重复计算，起始都是{1,2}构成的组合，这里实际上计算的是排列数{1,2}和{2,1}
     */
    public int changeV1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历所有金额
            for (int i = 0; i < coins.length; i++) { // 遍历所有的面额
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    /**
     * 计算并返回可以凑成总金额所需的最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            int countJ = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (j >= coins[i]) {
                    if (dp[j - coins[i]] != -1) {
                        countJ = Math.min(1 + dp[j - coins[i]], countJ);
                    }
                }
            }
            if (countJ == Integer.MAX_VALUE) {
                countJ = -1;
            }
            dp[j] = countJ;
        }
        return dp[amount];
    }
}
