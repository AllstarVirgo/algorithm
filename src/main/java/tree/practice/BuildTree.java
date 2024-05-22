package tree.practice;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode build(int[] inorder, int[] postorder
            , int inorderStart, int inorderEnd
            , int postorderStart, int postorderEnd
    ) {
        if (postorderStart == postorderEnd) {
            return null;
        }
        int val = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(val);
        int middleIndex = inorderStart;
        for (; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == val) {
                break;
            }
        }

        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);
        int rightPostorderStart = leftPostorderEnd;
        int rightPostorderEnd = postorderEnd - 1;
        root.left = build(inorder, postorder, leftInorderStart, leftInorderEnd, leftPostorderStart, leftPostorderEnd);
        root.right = build(inorder, postorder, rightInorderStart, rightInorderEnd, rightPostorderStart, rightPostorderEnd);
        return root;
    }
}
