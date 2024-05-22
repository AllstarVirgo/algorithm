package tree.practice;

import tree.TreeNode;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int maxIndex = start, max = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);

        int leftEnd = maxIndex;
        int rightStart = maxIndex + 1;

        root.left = build(nums, start, leftEnd);
        root.right = build(nums, rightStart, end);

        return root;
    }
}
