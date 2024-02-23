package sort;

import java.util.Objects;

public class SelectSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        if (Objects.isNull(arr)) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            switchPosition(arr, i, minIndex);
        }
    }
}
