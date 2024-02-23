package sort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, mid + 1, end);
    }

    private void merge(int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int length = rightEnd - leftStart + 1;
        int[] temp = new int[length];
        int i = leftStart, j = rightStart, cur = 0;
        while (i <= leftEnd && j <= rightEnd) {
            if (array[i] <= array[j]) {
                temp[cur++] = array[i];
                i++;
            } else {
                temp[cur++] = array[j];
                j++;
            }
        }
        int copyStart = i, copyEnd = leftEnd;
        if (i > leftEnd) {
            copyStart = j;
            copyEnd = rightEnd;
        }
        for (int k = copyStart; k <= copyEnd; k++) {
            temp[cur++] = array[k];
        }
        for (int k = 0; k < length; k++) {
            array[leftStart++] = temp[k];
        }
    }
}
