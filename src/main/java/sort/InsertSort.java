package sort;

import java.util.Objects;

public class InsertSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > cur) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = cur;
        }
    }
}
