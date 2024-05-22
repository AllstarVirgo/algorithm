package tree.practice;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            res = deque.getFirst().val;
            final int currentQueueSize = deque.size();
            for (int i = 0; i < currentQueueSize; i++) {
                final TreeNode offeredNode = deque.removeFirst();
                if (offeredNode.left != null) {
                    deque.offerLast(offeredNode.left);
                }
                if (offeredNode.right != null) {
                    deque.offerLast(offeredNode.right);
                }
            }
        }
        return res;
    }

    private int maxDepth = Integer.MIN_VALUE;

    private int res = 0;

    public void findBottomLeftValuePreOrder(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
        }
        findBottomLeftValuePreOrder(root.left, depth + 1);
        findBottomLeftValuePreOrder(root.right, depth + 1);
    }
}
