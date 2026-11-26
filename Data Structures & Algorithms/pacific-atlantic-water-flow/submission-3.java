class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void dfs(int i, int j, boolean[] check, int[][] heights, boolean[][] visited){
        if(i==0 || j==0) check[0] = true;
        if(i==r-1 || j==c-1) check[1] = true; 
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && heights[adjRow][adjCol]<=heights[i][j]){
                dfs(adjRow, adjCol, check, heights, visited);
            }
        }
    }

    public boolean bfs(int i, int j, int[][] heights){
        boolean pacific = false;
        boolean atlantic = false;

        boolean[][] visited = new boolean[r][c];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            if(currRow==0 || currCol==0) pacific = true;
            if(currRow==r-1 || currCol==c-1) atlantic = true;

            for(int[] d : directions){
                int adjRow = currRow + d[0];
                int adjCol = currCol + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && heights[adjRow][adjCol]<=heights[currRow][currCol]){
                    visited[adjRow][adjCol] = true;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
        return pacific && atlantic;
    }

    public void dfs(int i, int j, int[][] heights, boolean[][] visited){
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && heights[adjRow][adjCol]>heights[i][j]){
                dfs(adjRow, adjCol, heights, visited);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        r = heights.length;
        c = heights[0].length;

        boolean[][] visitedPacific = new boolean[r][c];
        boolean[][] visitedAtlantic = new boolean[r][c];
        for(int j=0 ; j<c ; j++){
            dfs(0, j, heights, visitedPacific);
            dfs(r-1, j, heights, visitedAtlantic);
        }

        for(int i=0 ; i<r ; i++){
            dfs(i, 0, heights, visitedPacific);
            dfs(i, c-1, heights, visitedAtlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(visitedPacific[i][j] && visitedAtlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;



        // r = heights.length;
        // c = heights[0].length;
        // List<List<Integer>> result = new ArrayList<>();
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         // boolean[][] visited = new boolean[r][c];
        //         // boolean[] check = {false, false};
        //         // dfs(i, j, check, heights, visited);
        //         // if(check[0] && check[1]){
        //         //     List<Integer> list = new ArrayList<>();
        //         //     list.add(i);
        //         //     list.add(j);
        //         //     result.add(list);
        //         // }


        //         if(bfs(i, j, heights)){
        //             List<Integer> list = new ArrayList<>();
        //             list.add(i);
        //             list.add(j);
        //             result.add(list);
        //         }
        //     }
        // }

        // return result;
        
    }
}
