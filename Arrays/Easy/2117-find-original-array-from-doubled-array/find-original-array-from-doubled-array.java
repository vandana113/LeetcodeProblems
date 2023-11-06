class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n<2) {
            return new int[0];
        }
        int [] orgArray = new int[n/2];
        Arrays.sort(changed);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        
        for(int i=0, k=0; i<n; i++) {
            // [1,3,4,2,6,8]
            // 1, 2, 3, 4, 6, 8
            System.out.print(changed[i]+" ");
            
            if(map.containsKey(changed[i])) {
                int doubleInt = changed[i] * 2;
                map.put(changed[i], map.get(changed[i]) - 1);
                if(map.get(changed[i]) == 0) {
                    map.remove(changed[i]);
                }
                if(map.containsKey(doubleInt)) {
                    orgArray[k++] = changed[i];
                    map.put(doubleInt, map.get(doubleInt) - 1);
                    if(map.get(doubleInt) == 0) {
                        map.remove(doubleInt);
                    }
                } else {
                    return new int[0];
                }
            }
            
        }
        if(orgArray.length != n/2){
            return new int[0];
        }
        return orgArray;
    }
}