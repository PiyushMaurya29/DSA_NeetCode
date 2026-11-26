class Solution {
    public boolean checkCycleDFS(int node, int parent, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                if(checkCycleDFS(adjNode, node, visited, adjList)){
                    return true;
                }
            }
            else if(adjNode != parent){
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        boolean result = checkCycleDFS(0, -1, visited, adjList);
        return result ? false : true;
    }
}
