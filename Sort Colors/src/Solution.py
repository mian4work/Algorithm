from typing import List


class Solution:

    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index, start, end = 0, 0, len(nums) - 1
        while index <= end:
            if nums[index] == 2:
                nums[index] = nums[end]
                nums[end] = 2
                end -= 1
            elif nums[index] == 0:
                nums[index] = 1
                nums[start] = 0
                start += 1
                index += 1
            else:
                index += 1

        # def swap(arr: List[int], start: int, end: int):
        #     temp1 = arr.pop(start)
        #     temp2 = arr.pop(end)
        #     arr.insert(end, temp1)
        #     arr.insert(start, temp2)
        #
        # first, last = 0, len(nums) - 1
        # for i in range(len(nums)):
        #     if nums[i] == 0:
        #         if nums[first] == 0:
        #             while nums[first] == 0:
        #                 first += 1
        #             if first != i:
        #                 swap(nums, first, i)
        #         elif nums[first] == 2:
        #             while nums


nums = [2, 0, 2, 1, 1, 0]
Solution().sortColors(nums)
print(nums)
