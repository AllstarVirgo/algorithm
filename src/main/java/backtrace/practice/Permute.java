package backtrace.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(nums, 0);
        return result;
    }

    private void permuteHelper(int[] nums, int startIndex) {
        if (startIndex >= nums.length) {
            return;
        } else {
            result.add(fromArray(nums));
        }
        for (int i = startIndex; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                exchange(nums, i, j);
                permuteHelper(nums, i + 1);
                exchange(nums, i, j);
            }
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> fromArray(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    public List<List<Integer>> permuteV1(int[] nums) {
        boolean[] selected = new boolean[nums.length];
        assign(nums, new ArrayList<>(), selected);
        return result;
    }

    private void assign(int[] nums, List<Integer> cur, boolean[] selected) {
        // 满足条件则加入
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        // 在这里描述三种选择.每一次递归都是从3种选择种---make choice
        // 为什么使用循环？因为在递归的过程中，总是面临nums.length种选择
        for (int i = 0; i < nums.length; i++) {
            // dfs，如果选过了就略过
            if (selected[i]) {
                continue;
            }
            cur.add(nums[i]);
            selected[i] = true;
            assign(nums, cur, selected);
            cur.remove(cur.size() - 1);
            selected[i] = false;
        }
    }
}
