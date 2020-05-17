class Solution:
    def reverseVowels(self, s: str) -> str:
        vow = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
        start, end = 0, len(s) - 1;
        while start < end:
            if s[start] not in vow:
                start += 1
            elif s[end] not in vow:
                end -= 1
            else:
                if s[start] != s[end]:
                    # the following switch not work
                    temp = s[end]
                    s = s.replace(s[end], s[start], 1)
                    s = s.replace(s[start], temp)
                start += 1
                end -= 1
        return s


print(Solution().reverseVowels("hello"))
