package heap;

public class PriorityQueue {

    private int[] array;

    private int count;

    public PriorityQueue() {
        this.array = new int[10];
    }

    public void offer(int val) {
        array[count++] = val;
        int i = count;
        while ((i - 1) / 2 >= 0 && array[i] > array[(i - 1) / 2]) {
            swap(array, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }

    }

    private void swap(int[] array, int i, int next) {
        int temp = array[i];
        array[i] = array[next];
        array[next] = temp;
    }

}
