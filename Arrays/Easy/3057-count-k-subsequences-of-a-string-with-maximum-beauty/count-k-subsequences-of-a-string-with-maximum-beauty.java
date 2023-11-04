class Solution {
    int M = 1000000007;
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        
        int [] chars = new int[26];
        int n = s.length();
        int [] freqChar = new int[n+1];
        int unique = 0;
        for(int i=0; i<n; i++) {
            char cc = s.charAt(i);
            chars[cc - 'a']++;
        }       

        // Sorting the chars
        for(int i=0; i<chars.length; i++) {
            if(chars[i]!=0) {
                int freq = chars[i];
                freqChar[freq]++;
                unique++;
            }
        }

        if(k > unique) {
            return 0;
        }
        
        int i=n;
        long result=1;
        while(k>0 && i>=0) {
            if(freqChar[i] == 0) {
                i--;
            } else if(k>=freqChar[i]) {
                k -= freqChar[i]; 
                result = (result * pow(i, freqChar[i])) % M;
                i--;
            } else {
                break;
            }
        }

        // for(int j=0; j<26; j++){
        //     System.out.print(chars[j] +" ");
        // }

        // NcR
        if(k>0) {
            
            long x = nCr(freqChar[i], k);
            long power = pow(i, k);

            long xPower = (x * power) % M;
            // System.out.println("i " + i +" k "+k +" x "+x+" result "+result +" xPower "+xPower);
            result = ((long)result * (long)xPower) % M;
        }
    
        return (int)result%M;
    }

    private long nCr(int n, int k) {
        long fact[] = new long[27];
        long invFact[] = new long[27];

        fact[1] = 1;

        for(int i=2; i<=26; i++) {
            fact[i] = (fact[i-1] * i) % M;
        }
        invFact[26] = pow(fact[26], M-2);

        for(int i=25; i>=0; i--) {
            invFact[i] = (invFact[i+1] * (i+1)) % M;
        }
        return (fact[n] * ((invFact[k] * invFact[n-k]) %M)) % M;
    }

    private long pow(long x, long n) {
        long result = 1;
        while(n != 0) {
            if(n%2 != 0) {
                result = (result * x) % M;
            }

            n=n/2;
            x = (x*x) % M;
        }

        return result;
    }
    
}