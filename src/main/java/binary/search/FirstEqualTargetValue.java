package binary.search;

public class FirstEqualTargetValue {

    public int findFirstEqual(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
