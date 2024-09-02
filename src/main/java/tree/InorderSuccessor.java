package tree;

public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return help(root, null, p.val);
    }

    private TreeNode help(TreeNode root, TreeNode parent, int target){
        if(target > root.val){
            return help(root.right, parent, target);
        } else if ( target < root.val){
            return help(root.left, root, target);
        }

        if(root.right != null){
            return findMin(root.left);
        } else {
            return parent;
        }
    }

    private TreeNode findMin(TreeNode root){
        if(root.left == null){
            return root;
        }
        return findMin(root.left);
    }
}
