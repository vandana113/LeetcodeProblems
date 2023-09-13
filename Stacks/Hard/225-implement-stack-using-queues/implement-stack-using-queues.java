class MyStack {
    Queue<Integer> queue;
    int front;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
       queue.add(x);
       int size = queue.size();
       while(size > 1) {
           int top = queue.remove();
           queue.add(top);
           size --;
       }
    }
    
    public int pop() {
       return queue.remove();
    }

    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */