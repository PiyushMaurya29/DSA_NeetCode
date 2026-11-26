class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == 1) freshCount++;
                else if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        if(freshCount == 0) return -1; // No fresh oranges present

        int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int time = 0;
        while(!queue.isEmpty()){
            time++;
            int levelSize = queue.size();
            for(int i=0 ; i<levelSize ; i++){
                int[] curr = queue.poll();
                for(int[] d : directions){
                    int adjRow = curr[0] + d[0];
                    int adjCol = curr[1] + d[1];
                    if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && grid[adjRow][adjCol]==1){
                        grid[adjRow][adjCol] = 2; // Make it rotten
                        freshCount--;
                        if(freshCount == 0){
                            return time;
                        }
                        queue.offer(new int[]{adjRow, adjCol});
                    }
                }
            }
        }
        return -1;
    }
}
