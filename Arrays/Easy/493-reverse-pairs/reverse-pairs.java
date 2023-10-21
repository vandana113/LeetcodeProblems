class Solution {
    int reversePairs = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return reversePairs;
    }

    public void mergeSort(int [] nums, int left, int right) {
        if(left>=right) {
            return;
        }

        int mid = (left + right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        countPairs(nums, left, mid+1, right);
        merge(nums, left, mid+1, right);
    }

    public void merge(int [] nums, int left, int mid, int right) {
        int [] temp = new int[right - left + 1];

        int i = left;
        int j = mid;
        int k = 0;
        while(i<=mid-1 && j<=right) {
            if(nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
                k++;
            } else {
                temp[k] = nums[j];
                j++;
                k++;
            }
        }

        while(i<=mid-1) { 
            temp[k] = nums[i];
            i++;
            k++;
        }

        while(j<=right) { 
            temp[k] = nums[j];
            j++;
            k++;
        }

        i = left;
        k = 0;
        for(i=left; i<=right; i++, k++) {
            nums[i] = temp[k];
        }
    }

    private void countPairs(int [] nums, int left, int mid, int right) {
        int j = mid;
        for(int i=left;i<=mid-1;i++) {
            while(j<=right && (nums[i] > ((long)nums[j] * 2))) {
                j++;
            }
            reversePairs += (j-mid);
        }
    }
}