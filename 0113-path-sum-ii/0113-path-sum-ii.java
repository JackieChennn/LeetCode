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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfsHelper(res, currList, root, targetSum);
        return res;
    }

    private void dfsHelper(List<List<Integer>> res, List<Integer> currList, TreeNode root, int remainingSum) {
        if (root == null) {
            return;
        }
        currList.add(root.val);
        if (remainingSum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(currList));
        } else {
            dfsHelper(res, currList, root.left, remainingSum - root.val);
            dfsHelper(res, currList, root.right, remainingSum - root.val);
        }
        currList.remove(currList.size() - 1);
    }
}