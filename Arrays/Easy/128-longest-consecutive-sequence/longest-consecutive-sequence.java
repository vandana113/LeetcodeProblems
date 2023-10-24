class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int maxLen = 0;
        for(int num: nums) {
            map.add(num);
        }

        for(int num: nums) {
            if(!map.contains(num-1)) {
                int temp = num;
                int len = 1;
                while(map.contains(temp+1)) {
                    temp++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}