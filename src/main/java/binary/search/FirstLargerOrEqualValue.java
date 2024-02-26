package binary.search;

public class FirstLargerOrEqualValue {

    public int firstLargerOrEqualValue(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= target) {
                if (mid == 0 || array[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }
        return right;
    }
}
