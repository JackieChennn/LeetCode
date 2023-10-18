# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        level = 1
        max_sum = -float('inf')
        curr_level = [root]
        result = 0
        while curr_level:
            new_level = []
            curr_sum = 0
            for node in curr_level:
                curr_sum += node.val
                if node.left:
                    new_level.append(node.left)
                if node.right:
                    new_level.append(node.right)
            curr_level = new_level
            if max_sum < curr_sum:
                result = level
                max_sum = curr_sum
            level += 1
        return result