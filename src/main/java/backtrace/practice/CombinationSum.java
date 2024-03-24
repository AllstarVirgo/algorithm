package backtrace.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /**
     * @param candidates 不包含重复项
     * @param target     大于0的正整数
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumBT(candidates, target, new ArrayList<>(), res);
        return res;
    }

    /**
     * error code 会产生重复项
     * 考虑candidates = [2,3,6,7], target = 7
     * 以2作为起点时，考虑了所有为、[2,3,6,7]为任意个的重复项组合在一起的case
     * 以3作为起点时，考考了所有[2,3,6,7]为任意个的重复项组合在一起的case，产生了重复
     * ...同上
     */
    private void combinationSumBT(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            cur.add(candidates[i]);
            combinationSumBT(candidates, target - candidates[i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * 这里约定了搜索的起点，因此也可以避免重复
     */
    private void combinationSumBTV1(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            combinationSumBTV1(candidates, target - candidates[i], cur, res, i);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * @param candidates candidates 中的每个数字在每个组合中只能使用 一次 。candidates中可能有重复项
     *                   按照组合数概念：从左往右遍历数组，对于每个数有2种可能，选择 or 放弃
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] chosen = new boolean[candidates.length];
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2BT(candidates, 0, target, chosen, new ArrayList<Integer>(), result);
        return result;
    }

    private void combinationSum2BT(int[] candidates, int index, int target, boolean[] chosen, ArrayList<Integer> cur,
                                   List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0 && index <= candidates.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        if (index > 0 && candidates[index - 1] == candidates[index] && !chosen[index - 1]) {
            combinationSum2BT(candidates, index + 1, target, chosen, cur, result);
            return;
        }
        chosen[index] = true;
        cur.add(candidates[index]);
        combinationSum2BT(candidates, index + 1, target - candidates[index], chosen, cur, result);
        chosen[index] = false;
        cur.remove(cur.size() - 1);
        combinationSum2BT(candidates, index + 1, target, chosen, cur, result);
    }

    /**
     * @param candidates candidates 中的每个数字在每个组合中只能使用 一次 。candidates中可能有重复项
     *                   换一种思路来解题，本质上是组合数的另一种实现
     *                   从左往右遍历数组，对于A1 -> An ，依次求一定包含Aj 和 不包含Aj的组合数
     */
    public List<List<Integer>> combinationSum2V2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2V2BT(candidates, target, 0, new boolean[candidates.length], new ArrayList<>(), res);
        return res;
    }

    private void combinationSum2V2BT(int[] candidates, int target, int index, boolean[] chosen, ArrayList<Integer> cur, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i] && !chosen[i - 1]) {
                continue;
            }
            chosen[i] = true;
            cur.add(candidates[i]);
            combinationSum2V2BT(candidates, target - candidates[i], i + 1, chosen, cur, res);
            chosen[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] candidates = new int[9];
        for (int i = 1; i <= 9; i++) {
            candidates[i - 1] = i;
        }
        combinationSum3BT(candidates, n, k, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void combinationSum3BT(int[] candidates, int target, int limit, int index, ArrayList<Integer> cur, List<List<Integer>> res) {
        if (cur.size() > limit || target < 0) {
            return;
        }
        if (target == 0 && cur.size() == limit) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            combinationSum3BT(candidates, target - candidates[i], limit, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }


    public int combinationSum4(int[] nums, int target) {
        int[] all = new int[target + 1];
        Arrays.fill(all, -1);
        return combinationSum4BT(nums, target, all);
    }

    private int combinationSum4BT(int[] nums, int target, int[] all) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((target - nums[i]) < 0) {
                continue;
            }
            if (all[target - nums[i]] == -1) {
                all[target - nums[i]] = combinationSum4BT(nums, target - nums[i], all);
            }
            res.add(all[target - nums[i]]);
        }
        return res.stream().mapToInt(Integer::intValue).sum();
    }

    public int combinationSum4DP(int[] nums, int target) {
        int[] all = new int[target + 1];
        all[0] = 1;
        for (int i = 1; i < all.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i - nums[j]) >= 0) {
                    sum += (all[i - nums[j]]);
                }
            }
            all[i] = sum;
        }
        return all[target];
    }
}
