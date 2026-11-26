class Solution {
    int r, c;
    int[][] directions;

    public void dfs(int i, int j, boolean[][] visited, int[][] grid, int[] count){
        visited[i][j] = true;
        count[0]++;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && grid[adjRow][adjCol]==1){
                dfs(adjRow, adjCol, visited, grid, count);
            }
        }
    }

    public void bfs(int i, int j, boolean[][] visited, int[][] grid, int[] count){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            count[0]++;

            for(int[] d : directions){
                int adjRow = curr[0] + d[0];
                int adjCol = curr[1] + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && grid[adjRow][adjCol]==1){
                    queue.offer(new int[]{adjRow, adjCol});
                    visited[adjRow][adjCol] = true;
                }
            }
        }
    }
    public int countServers(int[][] grid) {
        r = grid.length;
        c = grid[0].length;

        directions = new int[][]{{-1,0}, {0,-1}, {0,1}, {1,0}};

        boolean[][] visited = new boolean[r][c];
        int resultCount = 0;
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int[] count = {0};
                    // dfs(i, j, visited, grid, count);
                    bfs(i, j, visited, grid, count);
                    if(count[0] > 1){
                        resultCount += count[0];
                    }
                }
            }
        }
        return resultCount;
    }
}