class Solution {

    public int getCount(int startNode, List<List<int[]>> adjList, int distanceThreshold){
        int n = adjList.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        minHeap.offer(new int[]{0, startNode}); // Distance and Node
        distance[startNode] = 0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int currDistance = curr[0];
            int currNode = curr[1];

            if(distance[currNode] < currDistance){
                continue;
            }

            for(int[] adj : adjList.get(currNode)){
                int adjNode = adj[0];
                int adjDistance = adj[1];
                
                int finalDistance = currDistance + adjDistance;
                if(finalDistance < distance[adjNode]){
                    distance[adjNode] = finalDistance;
                    minHeap.offer(new int[]{finalDistance, adjNode});
                }
            }
        }
        int count = 0;
        for(int i=0 ; i<n ; i++){
            if(distance[i] <= distanceThreshold){
                count++;
            }
        }
        return count;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(new int[]{e[1], e[2]});
            adjList.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int[] count = new int[n];
        int minCount = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            int currCount = getCount(i, adjList, distanceThreshold);
            minCount = Math.min(minCount, currCount);

            count[i] = currCount;
        }
        for(int i=n-1 ; i>=0 ; i--){
            if(count[i] == minCount){
                return i;
            }
        }
        return -1;
    }
}
