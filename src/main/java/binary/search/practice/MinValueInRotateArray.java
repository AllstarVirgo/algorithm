package binary.search.practice;

public class MinValueInRotateArray {

    public int minValueInRotateArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[left]) {
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[mid];
    }

    public int minValueInRotateArraySimplerVersion(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
