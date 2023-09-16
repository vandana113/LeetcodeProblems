class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);
        for(int i=0; i<heights.length; i++) {
            int curr = heights[i];
            while(stack.peek() !=-1 && curr<=heights[stack.peek()]) {
                int top = stack.peek();
                stack.pop();
                
                int leftMost = stack.peek();
                
                int rect = (i - leftMost - 1) * heights[top];
                result = Math.max(rect, result);
            }
            stack.push(i);
        }
        int rightMost = heights.length;
        while(stack.peek()!=-1) {
            int top = stack.peek();
            stack.pop();

            int leftMost = stack.peek();
            
            int rect = (rightMost - leftMost - 1) * heights[top];
            result = Math.max(rect, result);
        }

        return result;
    }
}