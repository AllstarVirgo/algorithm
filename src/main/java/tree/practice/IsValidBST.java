package tree.practice;

import tree.TreeNode;

import java.util.Objects;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (!allLess(root.left, root.val)) {
            return false;
        }
        if (!allBigger(root.right, root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean allLess(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (root.val >= val) {
            return false;
        }
        return allLess(root.left, val) && allLess(root.right, val);
    }

    private boolean allBigger(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (root.val <= val) {
            return false;
        }
        return allBigger(root.left, val) && allBigger(root.right, val);
    }


    private boolean isValidBSTHelper(TreeNode root, long left, long right) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return isValidBSTHelper(root.left, left, root.val) && isValidBSTHelper(root.right, root.val, right);
    }

    public boolean isValidBSTV2(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
