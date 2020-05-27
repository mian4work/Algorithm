from typing import List

# a good explanation
# https://leetcode.com/problems/contiguous-array/discuss/99655/Python-O(n)-Solution-with-Visual-Explanation
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        index_map, max_value, count = {0: 0}, 0, 0
        for i, num in enumerate(nums, 1):
            if num == 0:
                count -= 1
            else:
                count += 1
            if count in index_map:
                max_value = max(max_value, i - index_map[count])
            else:
                index_map[count] = i
        return max_value

    # Misunderstand the question. I thought it should also be in order, e.g. 1010 is ok, 1001 is not ok but both
    # are ok
    def findMaxLengthFirstTry(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        max_len, start, end, local = 0, 0, 2, 0
        while end < len(nums) - 1 and start < len(nums) - 1:
            if nums[start] != nums[start + 1] and nums[start] == nums[end] and nums[start + 1] == nums[end + 1]:
                local += 4
                start += 2
                end += 2
            else:
                start += 1
                end += 1
                max_len = max(max_len, local)

        return max_len


print(Solution().findMaxLength([1, 0, 0, 1, 1, 0]))
print(Solution().findMaxLength([1, 0, 0, 1, 1]))
