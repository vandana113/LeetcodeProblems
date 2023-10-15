class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        int i = 0;
        int j = 0;
        int [] result = new int[m+n];

        while(i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                k++;
                i++;
            } else if(nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                k++;
                j++;
            } 
        }

        while(i<m) { 
            result[k] = nums1[i];
            k++;
            i++;
        }

        while(j<n) {
            result[k] = nums2[j];
            k++;
            j++;
        }

        for(i=0; i<m+n; i++) {
            nums1[i] = result[i];
        }
    }
}