class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        chars_s = [0]*26
        chars_t = [0]*26
        for c in s:
            chars_s[ord(c)-ord('a')] += 1
        for c in t:
            chars_t[ord(c)-ord('a')] += 1

        for i in range(26):
            if chars_s[i] != chars_t[i]:
                return False
        return True

        