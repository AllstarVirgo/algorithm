package heap;

import java.util.PriorityQueue;

public class MergeSortedArray {

    static class Node implements Comparable<Node> {

        int sourceArrayIndex;

        int value;

        int currentIndex;

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

        public Node(int sourceArrayIndex, int value) {
            this.sourceArrayIndex = sourceArrayIndex;
            this.value = value;
        }

        public Node(int sourceArrayIndex, int value, int currentIndex) {
            this.sourceArrayIndex = sourceArrayIndex;
            this.value = value;
            this.currentIndex = currentIndex;
        }
    }


    public int[] mergeSortedArray(int[][] array) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            priorityQueue.add(new Node(i, array[i][0]));
        }
        int row = array.length;
        int column = array[0].length;
        int[] res = new int[row * column];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            final Node minNode = priorityQueue.poll();
            res[index++] = minNode.value;
            if (minNode.currentIndex < (column - 1)) {
                int nextValue = array[minNode.sourceArrayIndex][minNode.currentIndex + 1];
                priorityQueue.add(new Node(minNode.sourceArrayIndex, nextValue, minNode.currentIndex + 1));
            }
        }
        return res;
    }
}
