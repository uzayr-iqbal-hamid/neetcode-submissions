class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }

    static int helper(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        if (arr[mid] == target){
            return mid;
        }

        if (arr[mid] >= arr[s]){
            if (arr[mid] >= target && arr[s] <= target) {
                return helper(arr, target, s, mid-1);
            } else {
                return helper(arr, target, mid+1, e);
            }
        }
        if (target <= arr[e] && target >= arr[mid]) {
            return helper(arr, target, mid+1, e);
        }
        return helper(arr, target, s, mid-1);
    }
}
