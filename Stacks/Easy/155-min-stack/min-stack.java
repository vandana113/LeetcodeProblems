class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int minEle;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            minEle = val;
        } else {
            if(val<=minEle) {
                minStack.push(minEle);
                minEle = val;
            }
        }
        stack.push(val);
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minEle && !minStack.isEmpty()) {
            minEle = minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */