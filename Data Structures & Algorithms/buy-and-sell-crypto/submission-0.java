class Solution {
    public int maxProfit(int[] prices) {
        int maximum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int currMax = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] - prices[i] > currMax) {
                    currMax = prices[j] - prices[i];
                }
            }
            maximum = Math.max(maximum, currMax);
        }
        return maximum;
    }
}
