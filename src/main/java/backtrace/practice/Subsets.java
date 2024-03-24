package backtrace.practice;

import java.util.*;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        select(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void select(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        select(nums, index + 1, cur, result);
        cur.remove(cur.size() - 1);
        select(nums, index + 1, cur, result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        selectV1(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public void selectV1(int[] nums, int index, List<Integer> cur, Set<List<Integer>> result) {
        if (index == nums.length) {
            if (!result.contains(cur)) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        cur.add(nums[index]);
        selectV1(nums, index + 1, cur, result);
        cur.remove(cur.size() - 1);
        selectV1(nums, index + 1, cur, result);
    }

    public List<List<Integer>> subsetsWithDupV2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        selectV2(nums, 0, new boolean[nums.length], new ArrayList<>(), result);
        return new ArrayList<>(result);
    }


    public void selectV2(int[] nums, int index, boolean[] visited, List<Integer> cur, Set<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (index > 0 && !visited[index - 1] && nums[index] == nums[index - 1]) {
            selectV2(nums, index + 1, visited, cur, result);
            return;
        }
        visited[index] = true;
        cur.add(nums[index]);
        selectV2(nums, index + 1, visited, cur, result);
        visited[index] = false;
        cur.remove(cur.size() - 1);
        selectV2(nums, index + 1, visited, cur, result);
    }


}
