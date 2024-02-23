package sort;

public class QuickSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = part(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private int part(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        int j = startIndex;
        for (int i = startIndex; i <= endIndex - 1; i++) {
            if (arr[i] < pivot) {
                switchPosition(arr, j++, i);
            }
        }
        switchPosition(arr, j, endIndex);
        return j;
    }

    /**
     * @param k from 1 to arr.length
     * @return 排名为k的元素
     */
    public int findTopKElement(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("error k, must from 1 to arr.length");
        }
        int targetIndex = k - 1;
        int partIndex = part(arr, 0, arr.length - 1);
        int left = 0, end = arr.length - 1;
        while (left <= end) {
            if (targetIndex > partIndex) {
                left = partIndex + 1;
            } else if (targetIndex < partIndex) {
                end = partIndex - 1;
            } else {
                return arr[partIndex];
            }
            partIndex = part(arr, left, end);
        }
        return -1;
    }
}
