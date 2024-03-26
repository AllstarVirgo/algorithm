package dp.practice;

public class FindLengthOfLCIS {

    /**
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * <p>
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,5,4,7]
     * 输出：3
     * 解释：最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,2,2,2]
     * 输出：1
     * 解释：最长连续递增序列是 [2], 长度为1。
     */
    public int findLengthOfLCIS(int[] nums) {
        // 从i开始的最长连续递增子序列
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        int res = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                dp[i] = 1 + dp[i + 1];
            } else {
                dp[i] = 1;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * 输出：3
     * 解释：长度最长的公共子数组是 [3,2,1] 。
     * 示例 2：
     * <p>
     * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
     * 输出：5
     * <p>
     * [0,1,1,1,1]  [1,0,1,0,1]
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                res = 1;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    /**
     * dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B
     * ，最长重复子数组长度为dp[i][j]。
     * （特别注意： “以下标i - 1为结尾的A” 标明一定是 以A[i-1]为结尾的字符串
     */
    public int findLengthV2(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        final char[] text1Chars = text1.toCharArray();
        final char[] text2Chars = text2.toCharArray();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1Chars[i - 1] == text2Chars[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）
     * 字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {
        final char[] text1Chars = s.toCharArray();
        final char[] text2Chars = t.toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int res = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (text1Chars[i - 1] == text2Chars[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res == s.length();
    }
}
