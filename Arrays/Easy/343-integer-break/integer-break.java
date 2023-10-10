class Solution {

    public int integerBreak(int n) {
        if(n <= 3) {
            return n-1;
        }
        int result = integerBreakHelper(n, new int[n+1]);
        return result;
    }

    public int integerBreakHelper(int n, int [] dp) {
        if(n <= 3) {
            return n;
        }
        if(dp[n]!=0) {
            return dp[n];
        }
        int result = n;
        for(int i=2; i<n; i++) {
            int second = integerBreakHelper(n-i, dp);
            result = Math.max(result, second * i);
        }
        dp[n] = result;
        return result;
    }
}