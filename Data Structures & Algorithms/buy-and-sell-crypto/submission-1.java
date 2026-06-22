class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int currP = prices[r] - prices[l];
                maxP = Math.max(currP, maxP);
            } else {
                l = r;
            }
            r += 1;
        }

        return maxP;
    }
}
