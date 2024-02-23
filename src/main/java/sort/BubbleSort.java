package sort;

import java.util.Objects;

public class BubbleSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            boolean switchFlag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    switchPosition(arr, j, j - 1);
                    switchFlag = true;
                }
            }
            if (!switchFlag) {
                return;
            }
        }
    }
}
