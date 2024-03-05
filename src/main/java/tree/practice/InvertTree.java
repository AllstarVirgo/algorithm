package tree.practice;

import tree.TreeNode;

import java.util.Objects;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(Objects.isNull(root)){
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
