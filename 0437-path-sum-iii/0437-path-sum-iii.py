# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import defaultdict
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def preorder(node: TreeNode, curr_sum: int) -> None:
            nonlocal count
            if not node:
                return
            curr_sum += node.val
            if curr_sum == k:
                count += 1
            count += hm[curr_sum - k]
            hm[curr_sum] += 1
            preorder(node.left, curr_sum)
            preorder(node.right, curr_sum)
            hm[curr_sum] -= 1
        count, k = 0, targetSum
        hm = defaultdict(int)
        preorder(root, 0)
        return count
