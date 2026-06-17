class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int peak = peakElem(nums);

        int b1 = minBinarySearch(nums, 0, peak);
        
        int b2 = -1;
        if (b1 != 1001)
            b2 = minBinarySearch(nums, peak + 1, nums.length - 1);
        
        return Math.min(b1, b2);

    }

    int minBinarySearch(int[] nums, int left, int right) {
        int min = 1001;

        while ( left <= right ) {
            int mid = left + ( right - left ) / 2;

            if ( nums[mid] < min ) {
                min = nums[mid];
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return min;
    }

    int peakElem(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while ( l <= r ) {
            int mid = l + ( r - l ) / 2;

            if ( mid < r && nums[mid] > nums[mid + 1] ) return mid;
            if ( mid > l && nums[mid] < nums[mid - 1] ) return mid - 1;
            
            if ( mid < r && nums[mid] <= nums[mid + 1] ) l = mid + 1;
            else r = mid - 1;
        }

        return r;
    }
}
