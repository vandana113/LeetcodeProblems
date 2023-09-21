class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i=1; i<n; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1; j<i; j++) {
                List<Integer> prevRow = result.get(i-1);
                row.add(prevRow.get(j-1) + prevRow.get(j)); 
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}