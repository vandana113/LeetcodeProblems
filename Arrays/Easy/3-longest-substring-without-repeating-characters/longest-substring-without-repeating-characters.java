class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        int len = 0;
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if(map.containsKey(cc)) {
                start = Math.max(start, map.get(cc) + 1);
            }
            len= (i - start + 1);
            maxLen = Math.max(maxLen, len);
            map.put(cc, i);
        }
        return maxLen;
    }

    
}