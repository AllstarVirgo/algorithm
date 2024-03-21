package stack.practice;

import java.util.Stack;

public class BiggerElementAtRight {

    /**
     * [2,6,3,8,10,9]
     * [6,8,8,10,-1,-1]
     */
    public int[] biggerElementAtRight(int[] array) {
        if (array == null) {
            return array;
        }
        int[] res = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) {
                int index = stack.pop();
                res[index] = array[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }
}
