package binary.search;

public class RotateArrayBinarySearch {

    public int search(int[] nums, int target) {
        int leftValue = nums[0];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (target >= leftValue) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if( target >= leftValue) {
                    left = mid + 1;
                } else {

                }
            }
        }
        return -1;
    }
}
