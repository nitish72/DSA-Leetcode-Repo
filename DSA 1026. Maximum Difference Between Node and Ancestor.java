// Date : 11 Jan 2024
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/?envType=daily-question&envId=2024-01-11

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        
        return dfs(root, root.val, root.val);
    }
    
    private int dfs(TreeNode node, int max, int min) {
        if (node == null) return max - min;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
    }
}
