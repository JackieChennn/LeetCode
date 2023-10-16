# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        arr = []
        pointer = head
        while pointer is not None:
            arr.append(pointer.val)
            pointer = pointer.next
        twin_sum = 0
        result = 0
        for i in range(len(arr) // 2):
            twin_sum = arr[i] + arr[len(arr) - 1 - i]
            result = max(twin_sum, result)
        return result
