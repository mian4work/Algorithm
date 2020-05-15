class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) == k:
            return num
        stack, i = [], 0
        while i < len(num):
            while len(stack) != 0 and k > 0 and stack[0] > num[i]:
                stack.pop(0)
                k -= 1
            stack.insert(0, num[i])
            i += 1
        while k > 0:
            stack.pop(0)
            k -= 1
        stack.reverse()
        while len(stack) > 0 and stack[0] == 0:
            stack.pop(0)
        if len(stack) == 0:
            return 0
        else:
            return "".join(stack)


print(Solution().removeKdigits("1234567890", 9))
print(Solution().removeKdigits("1432219", 3))
