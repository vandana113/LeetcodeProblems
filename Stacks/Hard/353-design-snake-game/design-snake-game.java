class SnakeGame {

    Deque<Integer> queue = new LinkedList<>();
    int score;
    Set<Integer> visited = new HashSet<>();
    HashMap<Integer, Integer> foodPlaces = new HashMap<>();
    int width;
    int height;
    int n;
    int foodCoord;
    int [][] food;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.n = width + height;
        for(int i=0; i<food.length; i++) {
            int foodIndex = food[i][0]*n + food[i][1];
            int freq = foodPlaces.getOrDefault(foodIndex, 0); 
            foodPlaces.put(foodIndex, freq+1);
        }
        
        int start = 0;
        queue.addLast(0);
        visited.add(0);

        foodCoord = 0;
        this.food = food;
        score = 0;
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
        System.out.println("Direction "+direction+" curr "+i+ " "+j);
        if(nexti>=0 && nexti<height && nextj>=0 && nextj<width) {
            int nextPlace = nexti*n + nextj;

            // Remove tail
            int tailPlace = queue.removeFirst();
            // System.out.println("REMOVED "+tail/n+ " "+tail%n);
            visited.remove(tailPlace);
            
            // Check if snake is already in that place
            if(visited.contains(nextPlace)) {
                System.out.println("snake already in box");
                return -1;
            }
            // Check if food is consumed
            if(canFoodBeConsumed(nexti, nextj)) {
                this.score++;
                System.out.println("food consumed");
                // Update food coord
                this.foodCoord++;

                queue.addFirst(tailPlace);
                visited.add(tailPlace);
            }
            
            System.out.println("ADD "+nexti+ " "+nextj);
            queue.addLast(nextPlace);
            visited.add(nextPlace);
        } else {
            // Out of bound
            System.out.println("snake out of bound");
            return -1;
        }

        return this.score;
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