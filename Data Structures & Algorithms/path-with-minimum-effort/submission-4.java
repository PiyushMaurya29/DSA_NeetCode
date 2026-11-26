class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int getRightRange(int[][] heights){
        int maxDiff = Integer.MIN_VALUE;
        for(int i=1 ; i<r ; i++){
            for(int j=1 ; j<c ; j++){
                maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i][j-1]));
                maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i-1][j]));
            }
        }
        return maxDiff;

        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        // for(int[] row : heights){
        //     for(int h : row){
        //         max = Math.max(max, h);
        //         min = Math.min(min, h);
        //     }
        // }
        // return max-min;
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
    public int minimumEffortPath(int[][] heights) {
        r = heights.length;
        c = heights[0].length;

        int left=0, right=getRightRange(heights);
        
        int result = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;
            boolean[][] visited = new boolean[r][c];
            if(isPossibleDFS(0, 0, mid, visited, heights)){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result==Integer.MAX_VALUE ? 0 : result;
    }
}