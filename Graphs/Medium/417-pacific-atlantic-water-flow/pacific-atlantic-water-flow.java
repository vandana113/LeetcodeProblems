class Solution {
    private static final int [][] DIRECTIONS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        if(m == 0 || n==0) {
            return new ArrayList<>();
        }
        boolean [][] pacificReachable = new boolean[m][n];
        boolean [][] atlanticReachable = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i, 0, heights, pacificReachable);
            dfs(i, n-1, heights, atlanticReachable);
        }
        for(int i=0;i<n;i++){
            dfs(0, i, heights, pacificReachable);
            dfs(m-1, i,heights, atlanticReachable);
        }

        List<List<Integer>> result =new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, int [][] heights, boolean [][] reachable) {
        reachable[i][j] = true;
        for(int [] dir: DIRECTIONS) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if(newRow<0 || newRow>=m || newCol<0 || newCol>=n) {
                continue;
            }

            if(reachable[newRow][newCol]) {
                continue;
            }

            if(heights[newRow][newCol] < heights[i][j]) {
                continue;
            }
            dfs(newRow, newCol, heights, reachable);
        }
        return;
    }
}