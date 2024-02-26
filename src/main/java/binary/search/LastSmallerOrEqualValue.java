package binary.search;

public class LastSmallerOrEqualValue {

    public int lastSmallerOrEqualValue(int[] array, int value) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] <= value) {
                if (mid == array.length - 1 || array[mid + 1] > value) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
