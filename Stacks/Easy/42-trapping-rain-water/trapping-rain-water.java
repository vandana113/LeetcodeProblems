class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int waterStored = 0;

        for(int i=0; i<height.length; i++) {
            while(!stack.isEmpty() && height[i]>height[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }

                int dist = i - stack.peek() - 1;
                int bound = Math.min(height[i],height[stack.peek()]) - height[top];
                waterStored+= dist*bound;
            }
            stack.push(i);
        }

        return waterStored;
    }
}