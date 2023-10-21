class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            if(i!=0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<n; j++) {
                if(j!=i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                
                List<List<Integer>>  subset = twoSum(nums, j+1, n-1, (long)target - (long)nums[i] - (long)nums[j], nums[i], nums[j]);

                for(List<Integer> set: subset) {
                    List<Integer> resultSubset = new ArrayList<>();
                    resultSubset.add(nums[i]);
                    resultSubset.add(nums[j]);

                    resultSubset.add(set.get(0));
                    resultSubset.add(set.get(1));

                    result.add(resultSubset);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int [] nums, int start, int end, long targetSum, int num1, int num2) {
        

        HashMap<Long, Integer> map= new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();    

        if(end-start+1<2){
            return res; 
        }

        for(int i=start; i<=end; i++) {
            if(res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]){  
                if(map.containsKey(targetSum-nums[i])) {
                    res.add(Arrays.asList((int)targetSum - nums[i], nums[i]));
                }
            }
            map.put((long)nums[i], i);
        }
        return res;
    }
}