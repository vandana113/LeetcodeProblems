class MyCircularQueue {
    int [] arr;
    int start;
    int end;
    int n;
    int count;
    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        n = k;
        end = -1;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if(count == n) {
            // Full
            return false;
        }
        end = (end+1)%n;
        arr[end] = value;     
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0) {
            // Empty
            return false;
        }
        arr[start] = -1;
        start = (start + 1)%n;
        count--;
        return true;
    }
    
    public int Front() {
        return count!=0 ? arr[start] : -1;
    }
    
    public int Rear() {
        return count!=0 ? arr[end] : -1;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == n;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */