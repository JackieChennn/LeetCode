class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = 'aeiou'
        count = 0
        for i in range(k):
            count += 1 if s[i] in vowels else 0
        max_count = count
        for i in range(len(s) - k):
            count += 1 if s[i + k] in vowels else 0
            count -= 1 if s[i] in vowels else 0
            max_count = max(max_count, count)
        return max_count
