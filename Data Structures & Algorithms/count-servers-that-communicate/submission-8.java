class Solution {
    int r, c;
    int[][] directions;

    public void dfs(int row, int col, boolean[][] visited, int[][] grid, int[] count){
        visited[row][col] = true;
        count[0]++;
        
        for(int i=0 ; i<r ; i++){
            if(grid[i][col]==1 && !visited[i][col]){
                dfs(i, col, visited, grid, count);
            }
        }
        for(int j=0 ; j<c ; j++){
            if(grid[row][j]==1 && !visited[row][j]){
                dfs(row, j, visited, grid, count);
            }
        }
    }

    public void bfs(int row, int col, boolean[][] visited, int[][] grid, int[] count){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            count[0]++;

            for(int j=0 ; j<c ; j++){
                if(grid[curr[0]][j]==1 && !visited[curr[0]][j]){
                    visited[curr[0]][j] = true;
                    queue.offer(new int[]{curr[0], j});
                }
            }
            for(int i=0 ; i<r ; i++){
                if(grid[i][curr[1]]==1 && !visited[i][curr[1]]){
                    visited[i][curr[1]] = true;
                    queue.offer(new int[]{i, curr[1]});
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
            parent[pv] = pu;
            rank[pu]++;
        }
    }
    public int countServers(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        
        parent = new int[r*c];
        size = new int[r*c];
        rank = new int[r*c];
        for(int i=0 ; i<r*c ; i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }

        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == 1){
                    for(int row=0 ; row<r ; row++){
                        if(grid[row][j]==1){
                            int parent1 = find(i * c + j);
                            int parent2 = find(row * c + j);
                            unionBySize(parent1, parent2);
                        }
                    }
                    for(int col=0 ; col<c ; col++){
                        if(grid[i][col]==1){
                            int parent1 = find(i * c + j);
                            int parent2 = find(i * c + col);
                            unionBySize(parent1, parent2);
                        }
                    }
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == 1){
                    int parent = find(i * c + j);
                    map.put(parent, map.getOrDefault(parent, 0)+1);
                }
            }
        }
        int resultCount = 0;
        for(int value : map.values()){
            if(value>1) resultCount += value;
        }
        return resultCount;
        



        // r = grid.length;
        // c = grid[0].length;
        // directions = new int[][]{{-1,0}, {0,-1}, {0,1}, {1,0}};
        // boolean[][] visited = new boolean[r][c];
        // int resultCount = 0;
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         if(grid[i][j]==1 && !visited[i][j]){
        //             int[] count = {0};
        //             // dfs(i, j, visited, grid, count);
        //             bfs(i, j, visited, grid, count);
        //             if(count[0] > 1){
        //                 resultCount += count[0];
        //             }
        //         }
        //     }
        // }
        // return resultCount;
    }
}