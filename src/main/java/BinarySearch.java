import java.util.*;

public class BinarySearch {

    public int search(int[] array, int target) {
        if (Objects.isNull(array)) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] < target) {
                right = mid - 1;
            } else if (array[mid] > target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static <T> void sort(T[] array, Comparator<T> comparator) {
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2cnt = new HashMap<>();
        for(int num : nums){
            num2cnt.put(num , num2cnt.getOrDefault(num ,0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                new Comparator<Integer>(){
                    @Override
                    public int compare(Integer a, Integer b){
                        return num2cnt.get(a) - num2cnt.get(b);
                    }
                }
        );
        for (Integer key : num2cnt.keySet()){
            if(pq.size() < k){
                pq.offer(key);
            } else if (pq.size() == k){
                if(pq.peek() < num2cnt.get(key)){
                    pq.poll();
                    pq.offer(key);
                }
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
