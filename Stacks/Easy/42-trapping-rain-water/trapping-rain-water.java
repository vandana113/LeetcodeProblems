class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = n-1;

        int waterStored = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                if(leftMax > height[left]) {
                    waterStored+= leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if(rightMax> height[right]) {
                    waterStored+= rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return waterStored;
    }
}