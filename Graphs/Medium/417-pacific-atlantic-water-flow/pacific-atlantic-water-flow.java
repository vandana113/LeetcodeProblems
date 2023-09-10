class Solution {
    private static final int [][] DIRECTIONS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        Queue<int[]> pacificOcean = new LinkedList<>();
        Queue<int[]> atlanticOcean = new LinkedList<>();

        for(int i=0;i<m;i++){
            pacificOcean.add(new int[]{i, 0});
            atlanticOcean.add(new int[]{i, n-1});
        }
        for(int i=0;i<n;i++){
            pacificOcean.add(new int[]{0, i});
            atlanticOcean.add(new int[]{m-1, i});
        }

        boolean [][] pacificReachable = bfs(heights, pacificOcean);
        boolean [][] atlanticReachable = bfs(heights, atlanticOcean);

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

    public boolean[][] bfs(int [][] heights, Queue<int[]> queue) {
        boolean [][] reachable = new boolean[m][n];
        

        while(!queue.isEmpty()) {
            int [] coord= queue.remove();
            int i = coord[0];
            int j = coord[1];
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
                queue.add(new int[]{newRow, newCol});
            }
        } 
        return reachable;
    }
}