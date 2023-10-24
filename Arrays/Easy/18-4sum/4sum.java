class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return result;
        }
        
        Arrays.sort(nums);

        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if(start == nums.length) {
            return result;
        }

        long average_value = target / k;
        
        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return result;
        }
        
        

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for(int i=start; i<nums.length; i++) {
            if(i!=start && nums[i] == nums[i-1]) {
                continue;
            }

            for(List<Integer> subset: kSum(nums, target - nums[i], i+1, k-1)) {
                result.add(new ArrayList<>(Arrays.asList(nums[i])));

                result.get(result.size() - 1).addAll(subset);
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int [] nums, long targetSum, int start) {
        

        HashSet<Long> map= new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();    

        for(int i=start; i<nums.length; i++) {
            if(res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]){  
                if(map.contains(targetSum - nums[i])) {
                    res.add(Arrays.asList((int)targetSum - nums[i], nums[i]));
                }
            }
            map.add((long)nums[i]);
        }
        return res;
    }
}