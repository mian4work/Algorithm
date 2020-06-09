class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        index_s, index_t = 0, 0
        while index_t < len(t):
            if s[index_s] == t[index_t]:
                index_s += 1
                if index_s == len(s):
                    return True
            index_t += 1
        return False


print(Solution().isSubsequence("abc", "ahbgdc"))
print(Solution().isSubsequence("acb", "ahbgdc"))