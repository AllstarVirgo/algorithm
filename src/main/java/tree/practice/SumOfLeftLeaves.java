package tree.practice;

import tree.TreeNode;

public class SumOfLeftLeaves {

    private int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        travel(root);
        return sum;
    }

    //  前序解法
    private void travel(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        travel(root.left);
        travel(root.right);
    }

    /**
     * 错误示范
     * @param root
     * @return
     */
    public int sumOfLeftLeavesV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lSum = sumOfLeftLeavesV2(root.left);
        int rSum = sumOfLeftLeavesV2(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // root.left.val 和lSum的关系没有弄清楚
            return root.left.val + lSum + rSum;
        }
        // 这里如果是0，"归"去的时候，都是0了
        return 0;
    }

    /**
     * 参考随想录的代码
     * 后序解法
     */
    public int sumOfLeftLeavesV3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lSum = sumOfLeftLeavesV3(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            lSum = root.left.val;
        }
        int rSum = sumOfLeftLeavesV3(root.right);
        return lSum + rSum;
    }
}
