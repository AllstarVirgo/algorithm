package binary.search.practice;

public class MinValueInRotateArrayWithSameElement {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] == nums[right]) {
                right -= 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
