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
}
