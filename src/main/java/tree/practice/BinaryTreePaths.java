package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        travel(root, "");
        return res;
    }

    private void travel(TreeNode root, String cur) {
        if (root == null) {
            return;
        }
        if(cur.length() == 0){
            cur += root.val;
        } else {
            cur += "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            res.add(cur);
            return;
        }
        if (root.left != null) {
            travel(root.left, cur);
        }
        if (root.right != null) {
            travel(root.right, cur);
        }
    }
}
