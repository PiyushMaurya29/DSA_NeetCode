class Solution {
    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode, visited, adjList);
            }
        }
    }

    public void bfs(int node, boolean[] visited, List<List<Integer>> adjList){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int adjNode : adjList.get(curr)){
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }
    }
    
    int[] parent, size, rank;
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void unionByRank(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;

        if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else if(rank[pv] > rank[pu]){
            parent[pu] = pv;
        }
        else{
            rank[pu]++;
            parent[pv] = pu;
        }
    }
    public void unionBySize(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;

        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        rank = new int[n];

        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            // unionByRank(u, v);
            unionBySize(u, v);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<n ; i++){
            set.add(find(i));
        }
        return set.size();




        // List<List<Integer>> adjList = new ArrayList<>();
        // for(int i=0 ; i<n ; i++){
        //     adjList.add(new ArrayList<>());
        // }
        // for(int[] e : edges){
        //     int u = e[0];
        //     int v = e[1];
        //     adjList.get(u).add(v);
        //     adjList.get(v).add(u);
        // }
        // boolean[] visited = new boolean[n];
        // int resultCount = 0;
        // for(int i=0 ; i<n ; i++){
        //     if(!visited[i]){
        //         resultCount++;
        //         // dfs(i, visited, adjList);
        //         bfs(i, visited, adjList);
        //     }
        // }
        // return resultCount;
    }
}
