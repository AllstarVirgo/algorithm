package tree.practice;

import tree.TreeNode;

import java.util.Objects;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(Objects.isNull(root)){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
