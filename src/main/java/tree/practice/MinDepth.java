package tree.practice;

import tree.TreeNode;

public class MinDepth {

    private int res = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travel(root, 1);
        return res;
    }

    /**
     * 前序遍历
     */
    private void travel(TreeNode root, int depth) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                res = Math.min(depth, res);
                return;
            }
            travel(root.left, depth + 1);
            travel(root.right, depth + 1);
        }
    }

    /**
     * 后序遍历
     */
    public int minDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int mlh = minDepthV2(root.left);
        int mrh = minDepthV2(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(mrh, mlh) + 1;
        } else if (root.left != null) {
            return 1 + mlh;
        } else {
            return 1 + mrh;
        }
    }
}
