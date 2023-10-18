# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        result = []
        nodes_list = [root]
        while nodes_list:
            sum = 0
            number = len(nodes_list)
            new_list = []
            for node in nodes_list:
                sum += node.val
                if node.left:
                    new_list.append(node.left)
                if node.right:
                    new_list.append(node.right)
            nodes_list = new_list
            result.append(sum / number)
        return result
