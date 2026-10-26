class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void dfs(int i, int j, boolean[][] visited, int[][] grid1, int[][] grid2, boolean[] check){
        if(grid1[i][j]==0){
            check[0] = false;
        }
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && grid2[adjRow][adjCol]==1){
                dfs(adjRow, adjCol, visited, grid1, grid2, check);
            }
        }
    }
    public void bfs(int i, int j, boolean[][] visited, int[][] grid1, int[][] grid2, boolean[] check){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(grid1[curr[0]][curr[1]] == 0){
                check[0] = false;
            }

            for(int[] d : directions){
                int adjRow = curr[0] + d[0];
                int adjCol = curr[1] + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && grid2[adjRow][adjCol]==1){
                    visited[adjRow][adjCol] = true;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        r = grid1.length;
        c = grid1[0].length;

        int resultCount = 0;

        boolean[][] visited = new boolean[r][c];
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid2[i][j]==1 && !visited[i][j]){
                    boolean[] check = {true};
                    // dfs(i, j, visited, grid1, grid2, check);
                    bfs(i, j, visited, grid1, grid2, check);
                    if(check[0]){
                        resultCount++;
                    }
                }
            }
        }
        return resultCount;
        
    }
}
