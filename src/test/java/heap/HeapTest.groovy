package heap

import spock.lang.Specification

class HeapTest extends Specification {

    def "heapify method should transform array into a min heap"() {
        given: "A Heap instance and a non-heapified array"
        Heap heap = new Heap()
        int[] array = [3, 2, 1, 5, 4]

        when: "heapify method is called"
        heap.heapify(array)

        then: "The array is transformed into a min heap"
        assert isMinHeap(array)
    }

    def "sort method should correctly sort an array"() {
        given: "A Heap instance and an unsorted array"
        Heap heap = new Heap()
        int[] unsorted = [5, 3, 2, 8, 1, 4]

        when: "sort method is called"
        heap.sort(unsorted)

        then: "The array is sorted in ascending order"
        unsorted == [1, 2, 3, 4, 5, 8]
    }

    boolean isMinHeap(int[] arr) {
        int n = arr.length
        // Start from root and go till the last internal node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // If left child is greater, return false
            if (arr[2 * i + 1] < arr[i]) {
                return false
            }
            // If right child is greater, return false
            if (2 * i + 2 < n && arr[2 * i + 2] < arr[i]) {
                return false
            }
        }
        return true
    }
}
