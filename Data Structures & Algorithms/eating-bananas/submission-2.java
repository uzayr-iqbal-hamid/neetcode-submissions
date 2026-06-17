class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Max(piles);

        int res = right;

        while (left <= right) {
            int k = left + (right - left) / 2;

            if(canEatInHours(piles, k) > h) {
                left = k + 1;
            } else {
                right = k - 1;
                res = k;
            }
        }
        return res;
    }

    int canEatInHours(int[] arr, int k) {
        int rate = 0;

        for (int i : arr) {
            rate += (i + k - 1) / k;
        }
        return rate;
    }

    int Max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
