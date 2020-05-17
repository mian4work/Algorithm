class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        open, close, start = 0, 0 , 0
        ans = []
        for i in range(0, len(S)):
            if S[i] == "(":
                open += 1
            if S[i] == ")":
                close += 1
            if open == close:
                ans.append(S[start + 1:i])
                start = i + 1
        return "".join(ans)


print(Solution().removeOuterParentheses("(()())(())"))
print(Solution().removeOuterParentheses("(()())(())(()(()))"))
print(Solution().removeOuterParentheses("(()())(())"))
