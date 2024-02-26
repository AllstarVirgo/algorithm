package binary.search;

public class RotateArrayBinarySearch {

    /**
     * 要在旋转数组中使用二分查找，我们需要细致地分析旋转数组的性质。
     * 旋转数组虽然整体不是有序的，但是至少有一半的区间是有序的。
     * 基于这个性质，我们可以修改传统的二分查找算法，让它适用于旋转数组
     *
     * !!! 次题未能解出
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // [left,mid] 为左侧有序
            if (nums[left] <= nums[mid]) {
                // 判断目标是否在左侧有序部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else /*[mid, right]为右侧有序*/ {
                // 判断目标是否在右侧有序部分
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
