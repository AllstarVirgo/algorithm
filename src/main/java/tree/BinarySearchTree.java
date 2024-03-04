package tree;

import java.util.Objects;

/**
 * Assuming no duplicate element
 */
public class BinarySearchTree {

    private TreeNode root;

    public TreeNode find(int val) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode cursor = root;
        while (cursor != null) {
            if (val == cursor.val) {
                return cursor;
            } else if (val > cursor.val) {
                cursor = cursor.right;
            } else {
                cursor = cursor.left;
            }
        }
        return null;
    }

    public void insert(int val) {
        if (Objects.isNull(root)) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cursor = root;
        while (true) {
            if (val > cursor.val) {
                if (cursor.right != null) {
                    cursor = cursor.right;
                } else {
                    cursor.right = new TreeNode(val);
                    return;
                }
            } else if (val < cursor.val) {
                if (cursor.left != null) {
                    cursor = cursor.left;
                } else {
                    cursor.left = new TreeNode(val);
                    return;
                }
            }
        }
    }

    public void delete(int val) {
        if (Objects.isNull(root)) {
            return;
        }
        // find target node and parent
        TreeNode deleteNode = root;
        TreeNode deleteNodeP = null;
        while (deleteNode != null) {
            deleteNodeP = deleteNode;
            if (val == deleteNode.val) {
                break;
            } else if (val < deleteNode.val) {
                deleteNode = deleteNode.left;
            } else {
                deleteNode = deleteNode.right;
            }
        }
        if (deleteNode == null) {
            return;
        }
        // find min node of delete node's right node
        if (deleteNode.left != null && deleteNode.right != null) {
            TreeNode minP = deleteNode.right;
            TreeNode minPP = deleteNodeP;
            // can't use min != null，min.left can be null
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            deleteNode.val = minP.val;
            deleteNode = minP;
            deleteNodeP = minPP;
        }
        TreeNode childOfDeleteNode;
        if (deleteNode.left != null) {
            childOfDeleteNode = deleteNode.left;
        } else if (deleteNode.right != null) {
            childOfDeleteNode = deleteNode.right;
        } else {
            childOfDeleteNode = null;
        }

        if (deleteNodeP == null) {
            root = null;
        } else if (deleteNodeP.left == deleteNode) {
            deleteNodeP.left = childOfDeleteNode;
        } else {
            deleteNodeP.right = childOfDeleteNode;
        }
    }

}
