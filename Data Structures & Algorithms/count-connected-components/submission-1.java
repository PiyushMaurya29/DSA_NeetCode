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
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int resultCount = 0;
        for(int i=0 ; i<n ; i++){
            if(!visited[i]){
                resultCount++;
                // dfs(i, visited, adjList);
                bfs(i, visited, adjList);
            }
        }
        return resultCount;
    }
}
