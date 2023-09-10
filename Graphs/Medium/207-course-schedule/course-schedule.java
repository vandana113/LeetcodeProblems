class Solution {
    boolean flag = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int [] inorder = new int[numCourses];
       for(int i=0; i<prerequisites.length; i++) {
           int prerequisite = prerequisites[i][0];;
           int course = prerequisites[i][1];
           if(graph[prerequisite] == null) {
               graph[prerequisite] = new ArrayList<>();
           }
           graph[prerequisite].add(course);
            inorder[course]++;
       }

       topoKahn(inorder, graph,numCourses);
       return flag;
    }

    public void topoKahn(int [] inorder, List<Integer>[] graph, int V) {   
        Queue<Integer> queueZeroDegree = new LinkedList<>();

        for(int i=0; i<V; i++){
            if(inorder[i] == 0) {
                queueZeroDegree.add(i);
            }
        }

        int visitedNodes = 0;
        while(!queueZeroDegree.isEmpty()) {
            int curr = queueZeroDegree.remove();
            List<Integer> neighbours = graph[curr];
            if(neighbours!=null) {
                for(int j=0; j<neighbours.size(); j++) {
                    if(--inorder[neighbours.get(j)] == 0) {
                        queueZeroDegree.add(neighbours.get(j));
                    }
                }
            }
            
            visitedNodes++;
        }
        flag = (visitedNodes == V);
        return;
    }
}