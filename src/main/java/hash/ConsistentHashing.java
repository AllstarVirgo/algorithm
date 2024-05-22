package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConsistentHashing {

    private String[] nodes;

    private long[] hashValues;

    private long MOD_VALUE = Long.MAX_VALUE;

    private Map<Long, String> hashcode2String;

    public ConsistentHashing(String... nodes) {
        this.nodes = nodes;
        init();
    }

    private void init() {
        this.hashValues = new long[this.nodes.length];
        this.hashcode2String = new HashMap<>();
        for (int i = 0; i < hashValues.length; i++) {
            hashValues[i] = Math.abs(nodes[i].hashCode()) % MOD_VALUE;
            hashcode2String.put(hashValues[i], nodes[i]);
        }
        Arrays.sort(hashValues);
    }

    private int findNextBigger(long hashValue) {
        int left = 0, right = hashValues.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (hashValues[mid] < hashValue) {
                left = mid + 1;
            } else {
                if (mid == 0 || hashValues[mid - 1] < hashValue) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    public String pickNode(long hashValue){
        int nextBigger = findNextBigger(hashValue);
        if(nextBigger == -1){
            nextBigger = 0;
        }
        return hashcode2String.get(hashValues[nextBigger]);
    }
}
