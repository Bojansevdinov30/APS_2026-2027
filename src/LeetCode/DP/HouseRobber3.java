package LeetCode.DP;

/*The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place
form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

Example 1:
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 10^4*/
public class HouseRobber3 {

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

    public int rob(TreeNode root) {
        int[] result = robTree(root);

        return Math.max(result[0], result[1]);
    }

    private int[] robTree(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = robTree(node.left);
        int[] right = robTree(node.right);

        // Don't rob this node
        int skip = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        // Rob this node
        int rob = node.val
                + left[0]
                + right[0];

        return new int[]{skip, rob};
    }

    public static void main(String[] args) {
        // something
    }
}
