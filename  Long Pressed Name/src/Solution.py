class Solution:
    def isLongPressedName(self, name, typed) -> bool:
        if name == typed:
            return True
        if name[-1] != typed[-1]:
            return False

        i = 0
        j = 0
        while i < len(name) and j < len(typed):
            c = name[i]
            if c != typed[j]:
                return False
            count1 = 0
            count2 = 0
            while i < len(name) and name[i] == c:
                count1 += 1
                i += 1
            while j < len(typed) and typed[j] == c:
                count2 += 1
                j += 1
            if count1 > count2:
                return False
        return True


print(Solution().isLongPressedName("helloo", "hhheelllo"))
