package binary.search.practice;

public class SearchRotateArray2 {

    /**
     * 二段性指的是数据集被一个条件分为两个明显不同的部分。在二分查找中，这通常是指数组中的元素与目标值的比较结果：小于目标值和大于（或等于）目标值。
     * 在应用二分查找时，你的目的是判断目标值在哪一部分，并相应地调整查找范围，逐步缩小这个范围。
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]){
                left = left + 1;
                right = right - 1;
            } else if (nums[mid] >= nums[left]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
