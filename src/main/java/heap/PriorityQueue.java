package heap;

public class PriorityQueue {

    private int[] array;

    private int count;

    public PriorityQueue() {
        this.array = new int[10];
    }

    /**
     * litte heap
     * @param val
     */
    public void offer(int val) {
        if (count == array.length) {
            return;
        }
        array[count++] = val;
        int i = count;
        while ((i - 1) / 2 >= 0 && array[i] > array[(i - 1) / 2]) {
            swap(array, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public int remove() {
        if (count <= 0) {
            throw new IllegalStateException();
        }
        int min = array[0];
        array[0] = array[--count];
        heapify(array, 0, count);
        return min;
    }

    private void heapify(int[] array, int i, int bound) {
        int min = i;
        int lSon = 2 * i + 1;
        int rSon = lSon + 1;
        if(lSon < bound && array[min] > array[lSon]){
            min = lSon;
        }
        if(rSon < bound && array[min] > array[rSon]){
            min = rSon;
        }
        if(min == i){
            return;
        }
        swap(array, i, min);
        heapify(array, min, bound);
    }

    private void swap(int[] array, int i, int next) {
        int temp = array[i];
        array[i] = array[next];
        array[next] = temp;
    }

}
