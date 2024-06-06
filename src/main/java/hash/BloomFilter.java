package hash;

import java.util.BitSet;

public class BloomFilter {

    /**
     * 位数组的大小
     */
    private static final int DEFAULT_SIZE = 2 << 24;

    /**
     * 位数组。数组中的元素只能是 0 或者 1
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);


    public void add(Object obj) {
        bits.set(obj.hashCode(), true);
    }

    public boolean contains(Object obj){
        return bits.get(obj.hashCode());
    }
}
