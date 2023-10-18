class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        index = 0
        pointer = 0
        count = 0
        while pointer < len(nums):
            if nums[pointer] != val:
                nums[index] = nums[pointer]
                index += 1
                count += 1
            pointer += 1
        return count
