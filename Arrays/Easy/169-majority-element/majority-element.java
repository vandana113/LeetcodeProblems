class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int count = nums.length/2;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int freq = map.getOrDefault(nums[i],0);
            if(freq>=count) {
                return nums[i];
            } 
            map.put(nums[i],freq+1);
        }
        return -1;
    }
}