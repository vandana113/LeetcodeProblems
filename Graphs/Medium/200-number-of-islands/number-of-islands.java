class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int noOfIslands = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return noOfIslands;
    }

    public void dfs(int i, int j, char [][] grid, boolean [][] visited) {
        if(visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if(i+1<grid.length && grid[i+1][j] == '1') {
            dfs(i+1, j, grid, visited);
        }
        if(j+1<grid[i].length && grid[i][j+1] == '1') {
            dfs(i, j+1, grid, visited);
        }   

        if(i>0 && grid[i-1][j] == '1') {
            dfs(i-1, j, grid, visited);
        }
        if(j>0 && grid[i][j-1] == '1') {
            dfs(i, j-1, grid, visited);
        }
    }
}