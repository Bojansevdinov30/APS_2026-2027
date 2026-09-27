package LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

/*Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique
values from 1 to n. Return the answer in any order.

Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

1 <= n <= 8*/
public class UniqueBinarySearchTrees2 {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // No nodes
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every value as the root
        for (int rootValue = start; rootValue <= end; rootValue++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees =
                    generate(start, rootValue - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees =
                    generate(rootValue + 1, end);

            // Combine every left subtree with every right subtree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(rootValue);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}
