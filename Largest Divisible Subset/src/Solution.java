import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in
    this subset satisfies:

    Si % Sj = 0 or Sj % Si = 0.

    If there are multiple solutions, return any subset is fine.

    Example 1:

    Input: [1,2,3]
    Output: [1,2] (of course, [1,3] will also be ok)

    Example 2:

    Input: [1,2,4,8]
    Output: [1,2,4,8]
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums); //sorting make sure we only compare next with previous
        //dp record max length from i-1, i-2, ... 0. the logic is checking if nums[i] % nums[j] == 0
        //if so, dp[i] = max(max, dp[j] + 1) because a new element nums[i] is added
        //if nums[i] can be divided by nums[j] and dp[j], let's say 2, means two previous elements which can be divide
        //nums[j] can also divide nums[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); //mean if there is only one element, the max length is 1
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            int max = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxIndex = dp[maxIndex] < dp[i] ? i : maxIndex;
        }

        //now we get the max length of qualified sub sequence, it is time to get the actual list of these elements.
        //transverse from high to low of dp, set the max = globalMax and remember the previous number nums[len -1] as prev.
        //push the last element in nums into list and max--.
        //if prev % nums[i] == 0 and dp[j] == max, push nums[i] into list and max--
        //until the loop finished
        int prev = nums[maxIndex], max = dp[maxIndex];
        for(int i = maxIndex; i >= 0; i--) {
            if(prev % nums[i] == 0 && dp[i] == max) {
                ans.add(nums[i]);
                prev = nums[i];
                max--;
            }
        }

        return ans;
    }

    /**
     * My first try failed.
     *
     * The idea is starting from the first element and compare with rest of elements.
     * whenever two matches (mod), add them in the list and remove them from the original list\
     *
     * But this won't work.
     *
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubsetFirstTry(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ans;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        helper(list, ans);
        if(ans.size() == 0) {
            ans.add(nums[0]);
        }
        return ans;
    }

    void helper(List<Integer> list, List<Integer> ans) {
        if(list.size() < 1) {
            return;
        }

        int curr = list.remove(0);
        int index = 0, size = list.size();
        while(index < size) {
            if(curr % list.get(index) == 0 || list.get(index) % curr == 0) {
                ans.add(curr);
                ans.add(list.remove(index));
                size = list.size();
                if(size == 1 && (curr % list.get(0) == 0 || list.get(0) % curr == 0)) {
                    ans.add(list.remove(0));
                }

                if(list.size() == 0) {
                    break;
                }
                curr = list.remove(0);
                index = 0;
            } else {
                index++;
            }
        }

        helper(list, ans);
    }
}
