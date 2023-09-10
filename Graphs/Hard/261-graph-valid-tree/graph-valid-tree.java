class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        boolean [] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                if(i!=0 || !findCycle(i, graph, visited, i)){
                    return false;
                }
            } else if(!visited[i] && i!=0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            graph[v2].add(v1);
            graph[v1].add(v2);

        }

        return graph;
    }

    public boolean findCycle(int v, List<Integer>[] graph, boolean [] visited, int parent) {
        System.out.println("-- "+v);

        visited[v] = true;

        for(int children: graph[v]) {
            System.out.println("children "+children);
            if(!visited[children]) {
                if(!findCycle(children, graph, visited, v)) {
                    return false;
                }
            } else if(parent!=children) {
                return false;
            }
            
        }


        return true;
    }
}