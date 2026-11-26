class Solution {
    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] time = new int[r][c];
        for(int[] row : time){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        time[0][0] = grid[0][0];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, 0, 0});
        int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int currTime = curr[0];
            int currRow = curr[1];
            int currCol = curr[2];
            for(int[] direction : directions){
                int adjRow = currRow + direction[0];
                int adjCol = currCol + direction[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c){
                    int maxTime = Math.max(currTime, grid[adjRow][adjCol]);
                    if(maxTime < time[adjRow][adjCol]){
                        time[adjRow][adjCol] = maxTime;
                        minHeap.offer(new int[]{maxTime, adjRow, adjCol});
                    }
                }
            }
        }
        return time[r-1][c-1];
    }
}
