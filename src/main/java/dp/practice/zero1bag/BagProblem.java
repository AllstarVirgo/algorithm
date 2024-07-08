package dp.practice.zero1bag;


import java.util.Arrays;

public class BagProblem {

    public int testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        // dp[i][j]从容量为0 - i个物品中取出重量小于等于j的背包
        int[][] dp = new int[weight.length][bagSize + 1];
        // 根据定义，初始化
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        return dp[weight.length - 1][bagSize];
    }


    public int wightBagProblemV2(int[] weight, int[] value, int bagSize) {
        // 容量为j的背包，所背的物品价值可以最大为dp[j]
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }
        return dp[bagSize];
    }

    /**
     * 一维数组场景下，如果先遍历每个重量，再遍历每个物品，就会出现错误的结果
     * 本质还是用了二维数组的更新思路，只是由于状态转移方程为：
     * dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
     * 由于i仅依赖于i - 1，j只依赖于当前j和j - weight[i]，使用dp[bagSize + 1]的一维数组，也可以滚动更新
     * 但是如果改变遍历顺序，无法实现滚动更新
     */
    public int wightBagProblemV3(int[] weight, int[] value, int bagSize) {
        // weight为j时的最大value
        int[] dp = new int[bagSize + 1];
        for (int j = bagSize; j >= 0; j--) {
            for (int i = 0; i < weight.length; i++) {
                if (j < weight[i]) {
                    continue;
                }
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[bagSize];
    }
}
