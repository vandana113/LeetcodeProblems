class Solution {
    int count = 0;
    int n; 
    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        int maxBomb = 0;
        for(int i=0; i<n; i++) {
            count = 0;
            System.out.println("-----");
            iterativeDfs(i, bombs);
            maxBomb = Math.max(count, maxBomb);
        }
        return maxBomb;
    }

    public void iterativeDfs(int i, int [][] bombs) {
        Stack<Integer> stack = new Stack<>();
        Set <Integer> visited = new HashSet<>();
        stack.push(i);
        visited.add(i);
        while(!stack.isEmpty()) {
            int popped = stack.pop();
            for(int j=0; j<n; j++) {
                if(!visited.contains(j) && connected(bombs[popped][0], bombs[popped][1], bombs[j][0],bombs[j][1],bombs[popped][2])) {
                    visited.add(j);
                    stack.push(j);
                }
            }
        }
        count = visited.size();
    }

    public boolean connected(int x1, int y1, int x2, int y2, int r) {
        long distance = (long)Math.pow(x2-x1, 2) + (long)Math.pow(y2-y1, 2);
        return distance <= ((long)Math.pow(r,2));
    }
}