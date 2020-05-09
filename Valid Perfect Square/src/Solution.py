class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num <= 1:
            return True
        start = 2
        end = num / 2 + 1
        while start <= end:
            mid = int((start + end) / 2)
            if mid*mid == num:
                return True
            elif mid*mid > num:
                end = mid - 1
            elif mid*mid < num:
                start = mid + 1
        return False


print(Solution().isPerfectSquare(808201))
