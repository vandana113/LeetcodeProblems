class Solution {
    public void sortColors(int[] nums) {
        int oneFreq = 0;
        int twoFreq = 0;
        int threeFreq = 0;

        int n = nums.length;

        for(int i=0; i<nums.length; i++) {
            switch(nums[i]) {
                case 0:
                    oneFreq++;
                    break;
                case 1:
                    twoFreq++;
                    break;
                case 2:
                    threeFreq++;
                    break;
            }
        }

        for(int i=0; i<n; i++) {
            if(oneFreq>0) {
                nums[i] = 0;
                oneFreq--;
            } else if(twoFreq>0) {
                nums[i] = 1;
                twoFreq--;
            } else {
                nums[i] = 2;
                threeFreq--;
            }
        }
    }
}