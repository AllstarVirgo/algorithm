package sort;

public abstract class AbstractSort {

    public void switchPosition(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public abstract void sort(int[] arr);
}
