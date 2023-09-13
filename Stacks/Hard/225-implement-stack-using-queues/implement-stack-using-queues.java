class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int front;
    int s = 0;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        front = x;
        queue1.add(x);
    }
    
    public int pop() {
       while(queue1.size()>1) {
           front = queue1.remove();
           queue2.add(front);
       }

       int removed = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return removed;
    }

    
    public int top() {
        return front;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
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