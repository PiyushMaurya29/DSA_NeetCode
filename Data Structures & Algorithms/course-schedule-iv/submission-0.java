class Solution {
    public boolean check(int u, int v, List<Integer> toposortList){
        int uIndex = -1;
        int vIndex = -1;
        for(int i=0 ; i<toposortList.size() ; i++){
            if(toposortList.get(i) == u){
                uIndex = i;
            }
            if(toposortList.get(i) == v){
                vIndex = i;
            }
        }
        return uIndex < vIndex;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<numCourses ; i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] p : prerequisites){
            int u = p[0];
            int v = p[1];
            inDegree[v]++;
            adjList.get(u).add(v);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<numCourses ; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> toposortList = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            toposortList.add(curr);

            for(int adjNode : adjList.get(curr)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for(int[] q : queries){
            int u = q[0];
            int v = q[1];

            boolean ans = check(u, v, toposortList);
            result.add(ans);
        }
        return result;
    }
}