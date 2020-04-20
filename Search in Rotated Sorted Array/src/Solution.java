/*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.

    Your algorithm's runtime complexity must be in the order of O(log n).

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
 */
public class Solution {
    /**
     * This is from discussion.
     *
     * Using binary search to find the pivot point. Then use pivot point as starting point (smallest point) to do the
     * binary search.
     *
     * We can imagine appending the front rotated elements to the end and form a sorted array starting from pivot.
     * But how to calculate the mid? for example we take the first three elements and append them to the end.
     *      1. The actual mid = (left + right) / 2 (actually from left + (right - left) / 2)
     *      2. The new one is starting from index (0,1,2) 3 (since we append first three element to the end)
     *      3. The new one is ended to index (len - 1 + 3)
     *      4. So the new mid is ((actual mid) + (rotation)) % len. Why is that?
     *          Since the real mid is shifted to right, we need to know how far it is shifted.
     *          When we append 4 to the end, for example: [4,5,6,7,0,1,2,3] -> [4,5,6,7,0,1,2,3,4,5,6,7]
     *          the new start is (index + rotation) % len. the rotation = (number rotated - 1)
     *          So the new start is (0 + 3) % 8 == 3, (1 + 3) % 8 == 4, ...
     *          Based on the idea of (index + rotation) % len, we can get the new mid as follow:
     *          ((actual mid) + rotation) % len
     *
     * No way for me to get this solution!!! See the comment in code to get the point.
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        //first find the pivot point
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2; //from left + (right - left) / 2
            if(nums[mid] > nums[right]) { //unsorted
                left = mid + 1;
            } else { //enter sorted
                right = mid;
            }
        }

        int pivot = left; //the index for the smallest elment

        //then we do the binary search for target
        left = 0; right = nums.length - 1;
        while(left <= right) {
            //IMPORTANT: we use mid to change left/right but use calculated actualMid to get the value and return the index
            //It is so easy to be confused!!!!!
            int mid = (left + right) / 2;
            int actualMid = (mid + pivot) % nums.length;
            if(nums[actualMid] == target) {
                return actualMid;
            } else if(target > nums[actualMid]) {
                left = mid + 1; //we change the mid, not the actualMid to narrow the scope
            } else {
                right = mid - 1; //we change the mid, not the actualMid to narrow the scope
            }
        }

        return -1;
    }

    /**
     * Copy of online solution
     *
     * @param A
     * @param n
     * @param target
     * @return
     */
    int search(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }

    /**
     * Failed because I want to work it out without finding the pivot point. We have to find it or using some other tech
     * to do the work.
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchFailed(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                if(nums[left] > target) {
                    left = mid + 1;
                } else if(nums[left] < target){
                    right = mid - 1;
                } else if(nums[left] == target){
                    return left;
                }
            } else { //target > mid
                if(nums[right] < target) {
                    right = mid - 1;
                } else if(nums[right] > target) {
                    left = mid + 1;
                } else if(nums[right] == target){
                    return right;
                }
            }
        }

        return -1;
    }
}
