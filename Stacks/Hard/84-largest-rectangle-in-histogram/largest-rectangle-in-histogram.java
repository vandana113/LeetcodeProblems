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
                int leftRect = (top - leftMost) * heights[top];
                int rightRect = (i - top - 1) * heights[top];
                // System.out.println("first "+i+" "+curr + " "+top + " " + leftMost + " "+leftRect + " "+ rightRect);
                result = Math.max(leftRect + rightRect, result);
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

            int leftHist = (top - leftMost) * heights[top];
            int rightHist = (rightMost - top) * heights[top];
// System.out.println("second "+top + " " + leftMost + " "+leftHist + " "+ rightMost + " "+rightHist+" "+(leftHist+rightHist));
            result = Math.max(rightHist + leftHist, result);
            // rightMost = top;
        }

        return result;
    }
}