class Solution:
    def hIndex(self, citations: List[int]) -> int:
        sorted_list = sorted(citations, reverse=True)
        index = 0
        while index < len(sorted_list):
            if index + 1 > sorted_list[index]:
                break
            index += 1
        return index
        