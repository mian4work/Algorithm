from typing import List


# Note: how to use dict and list
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans = []
        dic = {}
        if nums is None or len(nums) == 0:
            return ans
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in dic:  # check key in dict
                ans.append(dic.get(diff))  # add element in list
                ans.append(i)
                break
            dic.update({nums[i]: i})  # add new key-value pair
        return ans
