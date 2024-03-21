package dp.practice;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLIS {


    /**
     * define: lis j: max sub increase array include array[i]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 这里还是必须要用到数组，因为在决策的时候，还是需要遍历所有的中间态
        int[] lis = new int[nums.length];
        lis[nums.length - 1] = 1;
        int res = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int maxLISFromI = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int lisJ = 1 + lis[j];
                    if (lisJ > maxLISFromI) {
                        maxLISFromI = lisJ;
                    }
                }
            }
            lis[i] = maxLISFromI;
            res = Math.max(res, maxLISFromI);
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxSubArray = new int[nums.length];
        maxSubArray[nums.length - 1] = nums[nums.length - 1];
        int res = maxSubArray[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            // 只依赖maxSubArray[i + 1] 和 maxSubArray[i]，因此不需要用到数组来存储所有的中间状态
            int maxSubArrayFromI = Math.max(nums[i], nums[i] + maxSubArray[i + 1]);
            maxSubArray[i] = maxSubArrayFromI;
            res = Math.max(maxSubArrayFromI, res);
        }
        return res;
    }

    public int maxSubArrayOpt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int subMax = nums[nums.length - 1];
        int res = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            subMax = Math.max(nums[i], nums[i] + subMax);
            res = Math.max(subMax, res);
        }
        return res;
    }

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> value2Index = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            value2Index.put(arr[i], i);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int prev = arr[i];
                int cur = arr[j];
                int count = 2;
                while (value2Index.containsKey(prev + cur)) {
                    int temp = prev + cur;
                    prev = cur;
                    cur = temp;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        if (res >= 3) {
            return res;
        }
        return 0;
    }

    /**
     * 1. 最优子结构：可以通过子问题的最优解，推导出问题的最优解
     * 2. 无后效性：在推导后面阶段的状态时，只关心前端阶段的状态值，不关心这个状态是怎么一步一步推导出来的；
     *  某阶段的状态一旦确定，就不受之后决策阶段的影响
     * 3. 重复子问题：不同的的决策序列，到达某个相同的阶段时，可能会产生重复的状态
     * @param arr
     * @return
     */
    public int lenLongestFibSubseqDP(int[] arr) {
        Map<Integer, Integer> value2Index = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            value2Index.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                final int nextVal = arr[i] + arr[j];
                if (value2Index.containsKey(nextVal)) {
                    int indexK = value2Index.get(nextVal);
                    dp[j][indexK] = Math.max(3, 1 + dp[i][j]);
                    res = Math.max(res, dp[j][indexK]);
                }
            }
        }
        if (res >= 3) {
            return res;
        }
        return 0;
    }
}
