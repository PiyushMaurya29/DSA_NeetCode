class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int getRightRange(int[][] heights){
        // This is Not working 
        // int maxDiff = Integer.MIN_VALUE;
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i][j-1]));
        //         maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i-1][j]));
        //     }
        // }
        // return maxDiff;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] row : heights){
            for(int h : row){
                max = Math.max(max, h);
                min = Math.min(min, h);
            }
        }
        return max-min;
    }
    public boolean isPossibleDFS(int i, int j, int diff, boolean[][] visited, int[][] heights){
        if(i==r-1 && j==c-1) return true;
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && Math.abs(heights[i][j]-heights[adjRow][adjCol])<=diff){
                if(isPossibleDFS(adjRow, adjCol, diff, visited, heights)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isPossibleBFS(int diff, int[][] heights){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
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
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && Math.abs(heights[curr[0]][curr[1]]-heights[adjRow][adjCol])<=diff){
                    visited[adjRow][adjCol] = true;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {
        r = heights.length;
        c = heights[0].length;
        int[][] effort = new int[r][c];
        for(int[] row : effort){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, 0, 0}); // Effort and Coordinates

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int currEffort = curr[0];
            int currRow = curr[1];
            int currCol = curr[2];
            for(int[] d : directions){
                int adjRow = currRow + d[0];
                int adjCol = currCol + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c){
                    int adjEffort = Math.abs(heights[currRow][currCol]-heights[adjRow][adjCol]);
                    int finalEffort = Math.max(adjEffort, currEffort);
                    if(finalEffort < effort[adjRow][adjCol]){
                        effort[adjRow][adjCol] = finalEffort;
                        minHeap.offer(new int[]{finalEffort, adjRow, adjCol});
                    }
                }
            }
        }
        return effort[r-1][c-1];


        // r = heights.length;
        // c = heights[0].length;

        // int left=0, right=getRightRange(heights);
        
        // int result = Integer.MAX_VALUE;
        // while(left <= right){
        //     int mid = left + (right-left)/2;
        //     // boolean[][] visited = new boolean[r][c];
        //     // if(isPossibleDFS(0, 0, mid, visited, heights)){
        //     //     result = mid;
        //     //     right = mid - 1;
        //     // }
        //     if(isPossibleBFS(mid, heights)){
        //         result = mid;
        //         right = mid - 1;
        //     }
        //     else left = mid + 1;
        // }
        // return result==Integer.MAX_VALUE ? 0 : result;
    }
}