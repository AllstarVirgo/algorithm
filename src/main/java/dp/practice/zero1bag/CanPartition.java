package dp.practice.zero1bag;

public class CanPartition {
    /**
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum % 2) == 1) {
            return false;
        }
        int target = sum >> 1;
        // 从数组中选取元素（可以不选），使得和为i
        boolean[] dp = new boolean[target + 1];
        // 如果不选,dp[0] = true是成立的
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
