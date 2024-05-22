package tree.practice;

import tree.TreeNode;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = getHeight(node.left);
        int rh = getHeight(node.right);
        if(lh == -1 || rh == -1){
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
    }
}
