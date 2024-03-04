package heap;

public class Heap {

    private void heapify(int[] array, int i, int bound) {
        int next = i;
        int lSonIndex = 2 * i + 1;
        int rSonIndex = 2 * i + 2;
        if (lSonIndex < bound && array[i] < array[lSonIndex]) {
            next = lSonIndex;
        }
        if (rSonIndex < bound && array[rSonIndex] > array[next]) {
            next = rSonIndex;
        }
        if (next != i) {
            swap(array, i, next);
            heapify(array, next, bound);
        }
    }

    private void swap(int[] array, int i, int next) {
        int temp = array[i];
        array[i] = array[next];
        array[next] = temp;
    }

    public void sort(int[] array) {
        /*
         *  l: 2 * i + 1
         *  r: 2 * i + 2
         *
         *  父节点： (i  - 1) / 2
         *  此处需要找到最后1个非叶子节点。没有比叶子节点更大的值，所以叶子节点不需要heapify
         *
         *  最后1个元素： (length - 1)
         *  带入公式 (i - 1) /2 ，得到 i = array.length / 2 - 1
         */
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i); // 将堆顶元素与最后一个元素交换
            heapify(array, 0, i); // 对剩余的堆进行堆化，注意这里的边界是i，因为最后的元素已经排好
        }

    }
}
