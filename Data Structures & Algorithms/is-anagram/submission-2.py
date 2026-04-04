class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dict_s = {}
        dict_t = {}
        for c in s:
            dict_s[c] = dict_s.get(c, 0) + 1
        for c in t:
            dict_t[c] = dict_t.get(c, 0) + 1

        for key, value in dict_s.items():
            if dict_t.get(key, 0) != value:
                return False
        for key, value in dict_t.items():
            if dict_s.get(key, 0) != value:
                return False
        return True

        