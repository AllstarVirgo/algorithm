package dp.practice;

public class MaxProduct {

    /**
     * error code
     */
    public int maxProduct(int[] nums) {
        int[][] productFromIAndJ = new int[nums.length][nums.length];
        int[][] minProductFromIAndJ = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            productFromIAndJ[i][i] = nums[i];
            minProductFromIAndJ[i][i] = nums[i];
        }
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > 0) {
                    productFromIAndJ[i][j] = Math.max(productFromIAndJ[i][j - 1] * nums[j], nums[j]);
                } else {
                    productFromIAndJ[i][j] = Math.max(minProductFromIAndJ[i][j - 1] * nums[j], nums[j]);
                }
                minProductFromIAndJ[i][j] = Math.min(minProductFromIAndJ[i][j - 1] * nums[j], nums[j]);
                if (productFromIAndJ[i][j] > result) {
                    result = productFromIAndJ[i][j];
                }
            }
        }
        return result;
    }

    /*
     * lc version
     */
    public int maxProductV2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
