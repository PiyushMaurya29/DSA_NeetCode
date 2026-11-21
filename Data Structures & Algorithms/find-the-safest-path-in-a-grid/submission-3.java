class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};

    public int[][] getDistance(int[][] grid){
        int[][] distance = new int[r][c];
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }
        
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int levelSize = queue.size();
            while(levelSize-- > 0){
                int[] curr = queue.poll();
                for(int[] d : directions){
                    int adjRow = curr[0] + d[0];
                    int adjCol = curr[1] + d[1];
                    if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && distance[adjRow][adjCol]==Integer.MAX_VALUE){
                        distance[adjRow][adjCol] = level;
                        queue.offer(new int[]{adjRow, adjCol});
                    }
                }
            }
        }
        return distance;
    }
    public boolean canReachDFS(int i, int j, int mid, boolean[][] visited, int[][] distance){
        
        if(distance[i][j] < mid) return false;
        if(i==r-1 && j==c-1) return true;

        visited[i][j] = true;

        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && distance[adjRow][adjCol]>=mid){
                if(canReachDFS(adjRow, adjCol, mid, visited, distance)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean canReachBFS(int mid, int[][] distance){
        if(distance[0][0] < mid) return false;

        boolean[][] visited = new boolean[r][c]; 
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0]==r-1 && curr[1]==c-1){
                return true;
            }

            for(int[] d : directions){
                int adjRow = curr[0] + d[0];
                int adjCol = curr[1] + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && distance[adjRow][adjCol]>=mid){
                    visited[adjRow][adjCol] = true;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
        return false;
    }

    public int solveDijkstra(int[][] distance){

        int[][] path = new int[r][c];
        for(int[] row : path){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        // Distance and Coordinates
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        maxHeap.offer(new int[]{distance[0][0], 0, 0});
        path[0][0] = distance[0][0];

        while(!maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();
            int currPath = curr[0];
            int currRow = curr[1];
            int currCol = curr[2];

            for(int[] d : directions){
                int adjRow = currRow + d[0];
                int adjCol = currCol + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c){
                    int finalPath = Math.min(currPath, distance[adjRow][adjCol]);
                    if(finalPath > path[adjRow][adjCol]){
                        path[adjRow][adjCol] = finalPath;
                        maxHeap.offer(new int[]{finalPath, adjRow, adjCol});
                    }
                }
            }
        }
        return path[r-1][c-1];
    }
    public int maximumSafenessFactor(int[][] grid) {
        r = grid.length;
        c = grid[0].length;

        // This will return the nearest distance for each cell from the thief cell
        int[][] distance = getDistance(grid);
        return solveDijkstra(distance);


        // r = grid.length;
        // c = grid[0].length;
        // // if(r==1 && c==1){
        // //     return 0;
        // // }

        // // This will return the nearest distance for each cell from the thief cell
        // int[][] distance = getDistance(grid);

        // int left=0, right=r+c;
        // int result = -1;
        // while(left <= right){
        //     int mid = left + (right-left) / 2;
        //     // boolean[][] visited = new boolean[r][c];
        //     // if(canReachDFS(0, 0, mid, visited, distance)){
        //     //     result = mid;
        //     //     left = mid + 1;
        //     // }
        //     // else{
        //     //     right = mid - 1;
        //     // }

        //     if(canReachBFS(mid, distance)){
        //         result = mid;
        //         left = mid + 1;
        //     }
        //     else{
        //         right = mid - 1;
        //     }
        // }
        // return result;
    }
}
