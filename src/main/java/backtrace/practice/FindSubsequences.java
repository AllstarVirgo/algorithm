package backtrace.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Map<Integer, Map<Integer, Boolean> > num2Idx = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            Map<Integer, Boolean> idx2Select = num2Idx.getOrDefault(nums[i], new HashMap<>());
            idx2Select.put(i, false);
            num2Idx.put(
                    nums[i],idx2Select
            );
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, num2Idx, 0
                , nums, new ArrayList<>());
        return res;
    }

    private void backtrace(List<List<Integer>> res
            , Map<Integer, Map<Integer, Boolean>> num2Idx
            , int idx, int[] nums, List<Integer> cur
    ){
        if(idx == nums.length && cur.size() > 1){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(skip(cur, nums, idx, num2Idx)){
            backtrace(res, num2Idx, idx + 1, nums, cur);
        } else {
            cur.add(nums[idx]);
            num2Idx.get(nums[idx]).put(idx, true);
            backtrace(res, num2Idx, idx + 1, nums, cur);
            cur.remove(cur.size() - 1);
            num2Idx.get(nums[idx]).put(idx, false);
            backtrace(res, num2Idx, idx + 1, nums, cur);
        }
    }

    private boolean skip(List<Integer> cur, int[] nums
            , int idx, Map<Integer, Map<Integer, Boolean> > num2Idx){
        boolean curSmaller = !cur.isEmpty() && nums[idx] < cur.get(cur.size() - 1);
        Map<Integer, Boolean> idx2Select = num2Idx.get(nums[idx]);
        for(Map.Entry<Integer, Boolean> entry: idx2Select.entrySet()){
            int idxVal = entry.getKey();
            if(idxVal < idx && !entry.getValue()){
                return true;
            }
        }
        return curSmaller;
    }
}
