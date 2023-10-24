class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        int maxLen = 0;
        for(int num: nums) {
            map.add(num);
        }

        for(int num: nums) {
            if(!map.contains(num-1)) {
                int temp = num;
                int len = 1;
                while(map.contains(++temp)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;

        // 4:1, 1:1, 3:1, 2:1 -> 4:2, 1:1, 3:2, 2:2
        // 3:4, 1:0, 2:2, 4:2
    }
}