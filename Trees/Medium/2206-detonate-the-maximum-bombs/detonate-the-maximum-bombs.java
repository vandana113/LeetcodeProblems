class Solution {
    int count = 0;
    int n; 
    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        boolean [] visited;
        int maxBomb = 0;
        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            count = 0;
            dfs(visited, i, bombs);
            maxBomb = Math.max(count, maxBomb);
        }
        return maxBomb;
    }

    public void dfs(boolean[] visited, int i, int [][] bombs) {

        if(visited[i]) {
            return;
        }

        count++;
        visited[i] = true;
        for(int j=0; j<n; j++) {
            if(!visited[j] && connected(bombs[i][0], bombs[i][1], bombs[j][0],bombs[j][1],bombs[i][2])) {
                dfs(visited, j, bombs);
            }
        }
    }

    public boolean connected(int x1, int y1, int x2, int y2, int r) {
        long distance = (long)Math.pow(x2-x1, 2) + (long)Math.pow(y2-y1, 2);
        return distance <= ((long)Math.pow(r,2));
    }
}