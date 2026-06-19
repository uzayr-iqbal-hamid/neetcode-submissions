class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int maxL = height[0];
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = maxL;
            if (height[i] > maxL) maxL = height[i];
        }

        int maxR = height[height.length-1];
        maxRight[height.length - 1] = maxR;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = maxR;
            if (height[i] > maxR) maxR = height[i];
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (Math.min(maxLeft[i], maxRight[i])  - height[i] >= 0) {
                result += Math.min(maxLeft[i], maxRight[i]) - height[i];
            } else continue;
        }

        return result;
    }
}
