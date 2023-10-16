class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        pref_sum = 0
        hm = {0 : 1}
        count = 0
        for num in nums:
            pref_sum += num
            count += hm.get(pref_sum - k, 0)
            if pref_sum in hm:
                hm[pref_sum] += 1
            else:
                hm[pref_sum] = 1
        return count
