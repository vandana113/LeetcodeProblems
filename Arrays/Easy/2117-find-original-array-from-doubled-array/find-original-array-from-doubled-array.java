class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n<2 || n%2!=0) {
            return new int[0];
        }
        int [] orgArr = new int[n/2];
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            maxVal = Math.max(maxVal, changed[i]);
        }

        int [] freq = new int[maxVal+1];

        for(int num: changed) {
            freq[num]++;
        }

        for(int i=0, k=0; i<=maxVal; i++) {
            if(freq[i] > 0) {
                freq[i]--;
                int twice = i * 2;
                if(twice<=maxVal && freq[twice] > 0) {
                    freq[twice]--;
                    orgArr[k++] = i;
                    i--;
                } else {
                    return new int[0];
                }
            }
        }
        return orgArr;
    }
}