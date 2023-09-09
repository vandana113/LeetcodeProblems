class Solution {
    class Vertex {
        int vtx;
        int wt;
        Vertex(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Vertex>[] network = buildNetwork(times, n);
        int [] shortestPath = findShortestPath(network, n, k);
        return findMaxTime(shortestPath);
    }

    public List<Vertex>[] buildNetwork(int [][] times, int n) {
        List<Vertex> [] network= new ArrayList[n+1];
        for(int [] t : times) {
            if(network[t[0]] == null) {
                network[t[0]] = new ArrayList<>();
            }
            network[t[0]].add(new Vertex(t[1], t[2]));
        }
        return network;
    }

    public int [] findShortestPath(List<Vertex>[] network, int n, int k) {
        int [] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Vertex> queue = new PriorityQueue<>(new Comparator<>() {
            public int compare (Vertex v1, Vertex v2) {
                return v2.wt - v1.wt;
            }
        });
        dist[k] = 0;
        queue.add(new Vertex(k, 0));

        while(!queue.isEmpty()) {
            Vertex v = queue.remove();
            if(network[v.vtx] == null) {
                continue;
            }
            for(Vertex neighbours: network[v.vtx]) {
                int nvtx = neighbours.vtx;
                int wt = neighbours.wt;
                if(dist[nvtx] > dist[v.vtx] + wt) {
                    dist[nvtx] = dist[v.vtx] + wt;
                    queue.add(new Vertex(nvtx, dist[nvtx]));
                }
            }
        }

        return dist;
    }

    public int findMaxTime(int [] dist) {
        int time = -1;
        int vtxVisited = 0;
        for(int timeTaken : dist) {
            if(timeTaken != Integer.MAX_VALUE) {
                time = Math.max(time, timeTaken);
                vtxVisited ++;
            }     
        }

        return (vtxVisited==dist.length - 1) ? time : -1;
    }
}