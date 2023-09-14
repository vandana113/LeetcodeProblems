class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] result = new int[nums1.length];
        for(int i=0; i<nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek()<nums2[i]) {
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int k = 0;
        for(int num : nums1) {
            result[k] = map.get(num);
            k++;
        }

        return result;
    }
}