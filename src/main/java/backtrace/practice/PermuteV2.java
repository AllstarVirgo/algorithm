package backtrace.practice;

import java.util.*;

public class PermuteV2 {

    public List<List<Integer>> permute(int[] array) {
        if (Objects.isNull(array)) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrace(array, res, new ArrayList<>(),  new HashSet<>());
        return res;
    }

    private void backtrace(int[] array, List<List<Integer>> res
            , ArrayList<Integer> someCase, HashSet<Integer> pickedIndex) {
        if (someCase.size() == array.length) {
            res.add(new ArrayList<>(someCase));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (pickedIndex.contains(i)) {
                continue;
            }
            someCase.add(array[i]);
            pickedIndex.add(i);
            backtrace(array, res, someCase, pickedIndex);
            someCase.remove(someCase.size() - 1);
            pickedIndex.remove(i);
        }
    }
}
