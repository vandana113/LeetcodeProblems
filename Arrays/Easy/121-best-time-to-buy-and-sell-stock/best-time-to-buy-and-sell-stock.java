class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max [] = new int[n+2];
        int min [] = new int[n+2];
        int maxProfit = 0;
        min[0] = prices[0];
        max[n+1] = prices[n-1];
        for(int i=0; i<=n-1; i++) {
            min[i+1] = Math.min(prices[i], min[i]);
            max[n-i] = Math.max(prices[n-i-1], max[n-i+1]);
        }

        for(int i=1;i<=n;i++) {
            maxProfit = Math.max(maxProfit, max[i] - min[i]);
        }
        return maxProfit;
    }
}