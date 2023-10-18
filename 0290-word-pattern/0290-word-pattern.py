class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        pattern_list = list(pattern)
        word_list = s.split(" ")
        if len(pattern_list) != len(word_list):
            return False
        pattern_map = {}
        word_map = {}
        for i in range(len(pattern_list)):
            if pattern_list[i] not in pattern_map:
                if word_list[i] in word_map:
                    return False
                else:
                    pattern_map[pattern_list[i]] = word_list[i]
                    word_map[word_list[i]] = pattern_list[i]
            else:
                if pattern_map[pattern_list[i]] != word_list[i]:
                    return False
        return True
