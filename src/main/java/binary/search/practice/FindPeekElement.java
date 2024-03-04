package binary.search.practice;

public class FindPeekElement {

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[mid + 1]){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
