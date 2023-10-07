class Pair<S, T> {
    public S first;
    public T second;

    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    List<Pair<Integer, Integer>> bucket;

    Bucket(){
        this.bucket = new ArrayList<>();
    }

    public void update(Integer key, Integer value) {
        boolean found = false;
        for(Pair<Integer,Integer> pair: this.bucket) {
            if(pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }
        if(!found) {
            this.bucket.add(new Pair<Integer,Integer>(key, value));
        }
    }

    public Integer get(Integer key) {
        for(Pair<Integer,Integer> pair: this.bucket) {
            if(pair.first.equals(key)) {
                return pair.second;
            }
        }
        return -1;
    }

    public void remove(Integer key) {
        for(Pair<Integer,Integer> pair: this.bucket) {
            if(pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}
class MyHashMap {
    int n = 2069;
    List<Bucket> map;
    public MyHashMap() {
        map = new ArrayList<>();
        for(int i=0; i<2069; i++) {
            this.map.add(new Bucket());
        }
    }
    
    public void put(int key, int value) {
        int hashValue = key%n;
        this.map.get(hashValue).update(key, value);
    }
    
    public int get(int key) {
        int hashValue = key%n;
        return this.map.get(hashValue).get(key);
    }
    
    public void remove(int key) {
        int hashValue = key%n;
        this.map.get(hashValue).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */