package backtrace.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 */
public class FactorCombinations {

    private List<Integer> t = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return ans;
    }

    /**
     *
     * @param target 目标数字
     * @param factor 因子
     */
    private void dfs(int target, int factor) {
        if (!t.isEmpty()) {
            List<Integer> cp = new ArrayList<>(t);
            cp.add(target);
            ans.add(cp);
        }
        for (int j = factor; j <= target / j; ++j) {
            if (target % j == 0) {
                t.add(j);
                dfs(target / j, j);
                t.remove(t.size() - 1);
            }
        }
    }

}
