class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Edge case
        // 1. Target=6, arr=[3,4,2]
        // 2. Target=6 arr=[3,3] how to find indices
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int second = target - nums[i]; //MAth.abs not neededbe
            int secondIdx = map.getOrDefault(second,-1);
            if(secondIdx>-1){
                result[0]=i;
                result[1]=secondIdx;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}