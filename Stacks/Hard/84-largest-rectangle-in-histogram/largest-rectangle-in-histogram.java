class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i=0; i<heights.length; i++) {
            int curr = heights[i];
            while(!stack.isEmpty() && curr<=heights[stack.peek()]) {
                int top = stack.peek();
                int leftMost = 0;
                stack.pop();
                if(stack.isEmpty()) {
                    leftMost = -1;
                } else {
                    leftMost = stack.peek();
                }
                int rect = (i - leftMost - 1) * heights[top];
                result = Math.max(rect, result);
            }
            stack.push(i);
        }
        int rightMost = 0;
        if(!stack.isEmpty()) {
            rightMost = stack.peek();
        }
        while(!stack.isEmpty()) {
            int top = stack.peek();
            stack.pop();
            int leftMost = -1;
            
            if(!stack.isEmpty()) {
                leftMost = stack.peek();
            }

            int rect = (rightMost - leftMost) * heights[top];
            result = Math.max(rect, result);
        }

        return result;
    }
}