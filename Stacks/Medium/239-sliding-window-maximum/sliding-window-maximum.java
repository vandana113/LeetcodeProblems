class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int [] result = new int[n-k+1];

        for(int i=0; i<k; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        result[0] = nums[dq.peekFirst()];

        for(int i=1; i<=n-k; i++) {
            if(dq.peekFirst() == i-1) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i+k-1] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.addLast(i+k-1);

            result[i] = nums[dq.peekFirst()];
        }

        return result;
    }
}