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
    // maxHeightAfterRemoval[x] = h, means if we remove node which value is x, then its max Height is h.
    private int[] maxHeightAfterRemoval = new int[100001];
    private int currentMaxHeight = 0;
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        traverseLeftToRight(root, 0);
        currentMaxHeight = 0;
        traverseRightToLeft(root, 0);
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = maxHeightAfterRemoval[queries[i]];
        }
        return res;
    }

    private void traverseLeftToRight(TreeNode node, int currentHeight) {
        if (node == null) {
            return;
        }
        maxHeightAfterRemoval[node.val] = currentMaxHeight;
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);
        traverseLeftToRight(node.left, currentHeight + 1);
        traverseLeftToRight(node.right, currentHeight + 1);
    }

    private void traverseRightToLeft(TreeNode node, int currentHeight) {
        if (node == null) {
            return;
        }
        maxHeightAfterRemoval[node.val] = Math.max(currentMaxHeight, maxHeightAfterRemoval[node.val]);
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);
        traverseRightToLeft(node.right, currentHeight + 1);
        traverseRightToLeft(node.left, currentHeight + 1);
    }
}