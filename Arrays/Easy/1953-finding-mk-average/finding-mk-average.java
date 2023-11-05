class MKAverage {

    TreeMap<Integer, Integer> l1 =new TreeMap<>();
    TreeMap<Integer, Integer> l2 =new TreeMap<>();
    TreeMap<Integer, Integer> l3 =new TreeMap<>();
    Queue<Integer> queue = new LinkedList<>();
    int l1Size = 0, l2Size = 0, l3Size = 0;
    int m, k, n;
    long totalSum = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.n = 0;
    }
    
    public void addElement(int num) {
        if(queue.size() == m) {
            int key = queue.remove();
            if(l1.containsKey(key)) {
                l1.put(key, l1.get(key) - 1);
                if(l1.get(key) == 0) {
                    l1.remove(key);
                }
                l1Size--;
            } else if(l2.containsKey(key)) {
                l2.put(key, l2.get(key) - 1);
                if(l2.get(key) == 0) {
                    l2.remove(key);
                }
                l2Size--;
                totalSum-=key;
            } else if(l3.containsKey(key)) {
                l3.put(key, l3.get(key) - 1);
                if(l3.get(key) == 0) {
                    l3.remove(key);
                }
                l3Size--;
            }

            if(l1Size < k) {
                int midKey = l2.firstKey();
                l1.put(midKey, l1.getOrDefault(midKey, 0) + 1);
                l1Size++;

                l2.put(midKey, l2.get(midKey) - 1);
                if(l2.get(midKey) == 0) {
                    l2.remove(midKey);
                }
                l2Size--;
                totalSum-=midKey;
            }
            if(l2Size < m- 2*k) {
                int rightKey = l3.firstKey();
                l2.put(rightKey, l2.getOrDefault(rightKey, 0) + 1);
                l2Size++;
                totalSum+=rightKey;

                l3.put(rightKey, l3.get(rightKey) - 1);
                if(l3.get(rightKey) == 0) {
                    l3.remove(rightKey);
                }
                l3Size--;
            }
        }

        queue.add(num);

        if(l1Size < k || num <= l1.lastKey()) {
            l1.put(num, l1.getOrDefault(num,0) + 1);
            l1Size++;
        } else if(l2Size < m-2*k || num <= l2.lastKey()) {
            l2.put(num, l2.getOrDefault(num,0) + 1);
            l2Size++;
            totalSum+=num;
        } else {
            l3.put(num, l3.getOrDefault(num,0) + 1);
            l3Size++;
        }

        if(l1Size>k) {
            int leftKey = l1.lastKey();
            l2.put(leftKey, l2.getOrDefault(leftKey, 0) + 1);
            l2Size++;
            totalSum+=leftKey;

            l1.put(leftKey, l1.get(leftKey) - 1);
            if(l1.get(leftKey) == 0) {
                l1.remove(leftKey);
            }
            l1Size--;
        } 
        if(l2Size > m-2*k) {
            int midKey = l2.lastKey();
            l3.put(midKey, l3.getOrDefault(midKey, 0) + 1);
            l3Size++;

            l2.put(midKey, l2.get(midKey) - 1);
            if(l2.get(midKey) == 0) {
                l2.remove(midKey);
            }
            l2Size--;
            totalSum-=midKey;
        }

    
        System.out.println(num + " l1 " + l1Size + " l2 " + l2Size + " l3 "+ l3Size + " sum "+ totalSum);
    }
    
    public int calculateMKAverage() {
        if(queue.size() < m) {
            return -1;
        }
        return (int)totalSum/(m - 2 * k);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */