class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row0 = new ArrayList<>();
        row0.add(1);
        result.add(row0);
        for(int i=1; i<n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                int first = (j-1) < 0 ? 0 : result.get(i-1).get(j-1);
                int second = (j>i-1) ? 0: result.get(i-1).get(j);

                row.add(first + second); 
            }
            result.add(row);
        }
        return result;
    }
}