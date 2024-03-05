package tree.practice;

import tree.TreeNode;

import java.util.Objects;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, targetSum, 0);
    }

    public boolean hasPathSumHelper(TreeNode root, int targetSum, int cur) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && (cur + root.val) == targetSum) {
            return true;
        }
        return hasPathSumHelper(root.left, targetSum, cur + root.val) || hasPathSumHelper(root.right, targetSum, cur + root.val);
    }
}
