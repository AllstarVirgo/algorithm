package tree.practice;

import tree.TreeNode;

public class TreeLCPractice {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        // 比较外侧
        boolean compareOutside = isSymmetric(left.left, right.right);
        // 比较内侧
        boolean compareInside = isSymmetric(left.right, right.left);
        return compareOutside && compareInside;
    }
}
