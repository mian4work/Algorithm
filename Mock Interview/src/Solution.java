import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if(T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    sum += nums[k];
                    for (int l = k + 1; l < nums.length; l++) {
                        sum += nums[l];
                        if (sum == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            if(!set.contains(list)) {
                                ans.add(list);
                                set.add(list);
                            }
                        }
                        sum -= nums[l];

                    }
                    sum -= nums[k];
                }
                sum -= nums[j];

            }
        }

        return ans;
    }

    void helper(int[] nums, int index, int target, int[] sum) {
        if(sum[0] == target) {
            return;
        }
    }


    public String licenseKeyFormatting(String S, int K) {
        String s = S.replaceAll("-", "");

        StringBuilder builder = new StringBuilder();

        int index = s.length();
        while(index >= 0) {
            builder.insert(0, "-" + s.substring(index - K, index));
            index -= K;
        }

        return builder.toString();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
