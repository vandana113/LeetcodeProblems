class SnakeGame {

    Deque<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    int width;
    int height;
    int n;
    int foodCoord;
    int [][] food;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.n = width + height;
    
        queue.addLast(0);
        visited.add(0);

        foodCoord = 0;
        this.food = food;
    }
    
    public int move(String direction) {
        int nexti = 0;
        int nextj = 0;
        int curr = queue.peekLast();
        int i = curr/n;
        int j = curr%n;
        switch(direction) {
            case "U":
                nexti = i-1;
                nextj = j;
                break; 
            case "L":
                nexti = i;
                nextj = j-1;
                break;
            case "R":
                nexti = i;
                nextj = j+1;
                break;
            case "D":
                nexti = i+1;
                nextj = j;
                break;
        }

        if(nexti<0 || nexti>=height|| nextj<0 || nextj>=width) {
            // Out of bound
            return -1;
        }
       
        int nextPlace = nexti*n + nextj;

        // Remove tail
        int tailPlace = queue.removeFirst();
        visited.remove(tailPlace);
            
        // Check if snake is already in that place
        if(visited.contains(nextPlace)) {
            return -1;
        }
        // Check if food is consumed
        if(canFoodBeConsumed(nexti, nextj)) {
            // Update food coord
            this.foodCoord++;

            // Add tail back
            queue.addFirst(tailPlace);
            visited.add(tailPlace);
        }
        queue.addLast(nextPlace);
        visited.add(nextPlace);
        

        return this.queue.size() - 1;
    }

    private boolean canFoodBeConsumed(int nexti,  int nextj) {
        if(this.foodCoord < this.food.length) {
            int [] currFoodPlace = this.food[this.foodCoord];
            return currFoodPlace[0] == nexti && currFoodPlace[1]== nextj;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */