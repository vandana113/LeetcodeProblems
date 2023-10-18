class Solution {
    public double myPow(double x, int n) {

        double ans = powHelper(x, Math.abs(n));

        if(n<0) {
            return 1/ans;
        } else {
            return ans;
        }
    }

    public double powHelper(double x, int n) {
        if(n==0) {
            return 1;
        } else if(n==1) {
            return x;
        } 

        int half = n/2;
        double finalAns = 0;
        double ans = powHelper(x,n/2);

        if(n%2 == 0) {
            finalAns = ans * ans;
        } else {
            finalAns = ans * ans * x;
        }

        return finalAns;
    }
}