class MKAverage {
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);
    PriorityQueue<Integer> minMiddle = new PriorityQueue<>((a, b) -> a - b);
    PriorityQueue<Integer> maxMiddle = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> vals = new LinkedList<>();
    Map<Integer, Integer> deleteLeft = new HashMap<>(), deleteRight = new HashMap<>(), deleteMinMiddle = new HashMap<>(), deleteMaxMiddle = new HashMap<>();
    
    long sum;
    int m, k;
    boolean flag;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        sum = 0;
        flag = false;
    }
    
    public void addElement(int num) {
        vals.offer(num);
        
        if (!flag && vals.size() == m) {
            initialize();
            flag = true;
        }
        else if (flag) {
            int lv = vals.poll();
            update(left, deleteLeft);
            update(right, deleteRight);
            if (!left.isEmpty() && left.peek() >= lv) {
                update(minMiddle, deleteMinMiddle);
                int v = minMiddle.poll();
                deleteMaxMiddle.put(v, deleteMaxMiddle.getOrDefault(v, 0) + 1);
                left.offer(v);
                deleteLeft.put(lv, deleteLeft.getOrDefault(lv, 0) + 1);
                sum -= v;
            }
            else if (!right.isEmpty() && right.peek() <= lv) {
                update(maxMiddle, deleteMaxMiddle);
                int v = maxMiddle.poll();
                deleteMinMiddle.put(v, deleteMinMiddle.getOrDefault(v, 0) + 1);
                right.offer(v);
                deleteRight.put(lv, deleteRight.getOrDefault(lv, 0) + 1);
                sum -= v;
            }
            else {
                deleteMinMiddle.put(lv, deleteMinMiddle.getOrDefault(lv, 0) + 1);
                deleteMaxMiddle.put(lv, deleteMaxMiddle.getOrDefault(lv, 0) + 1);
                sum -= lv;
            }
            
            update(left, deleteLeft);
            update(right, deleteRight);
            if (!left.isEmpty() && left.peek() >= num) {
                int v = left.poll();
                minMiddle.offer(v);
                maxMiddle.offer(v);
                left.offer(num);
                sum += v;
            }
            else if (!right.isEmpty() && right.peek() <= num) {
                int v = right.poll();
                minMiddle.offer(v);
                maxMiddle.offer(v);
                right.offer(num);
                sum += v;
            }
            else {
                minMiddle.offer(num);
                maxMiddle.offer(num);
                sum += num;
            }
        }
    }
    
    public int calculateMKAverage() {
        // System.out.println(sum);
        return flag? (int)(sum / (m - 2 * k)) : -1;
    }
    
    private void initialize() {
        int i;
        for (i = 0; i < m; ++i) {
            int v = vals.poll();
            minMiddle.offer(v);
            maxMiddle.offer(v);
            sum += v;
            vals.offer(v);
        }
        i = 0;
        while (i < k) {
            update(minMiddle, deleteMinMiddle);
            int v = minMiddle.poll();
            left.offer(v);
            deleteMaxMiddle.put(v, deleteMaxMiddle.getOrDefault(v, 0) + 1);
            sum -= v;
            i ++;
        }
        
        i = 0;
        while (i < k) {
            update(maxMiddle, deleteMaxMiddle);
            int v = maxMiddle.poll();
            right.offer(v);
            deleteMinMiddle.put(v, deleteMinMiddle.getOrDefault(v, 0) + 1);
            sum -= v;
            i ++;
        }
    }
    
    private void update(PriorityQueue<Integer> pq, Map<Integer, Integer> delete) {
        while (!pq.isEmpty() && delete.containsKey(pq.peek()) && delete.get(pq.peek()) > 0) {
            int v = pq.poll();
            delete.put(v, delete.get(v) - 1);
            if (delete.get(v) == 0)
                delete.remove(v);
        }
    }
}