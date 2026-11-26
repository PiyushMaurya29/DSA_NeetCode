class Solution {
    int r, c;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int getRange(int[][] heights){
        int maxDiff = Integer.MIN_VALUE;
        for(int i=1 ; i<r ; i++){
            for(int j=1 ; j<c ; j++){
                maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i-1][j]));
                maxDiff = Math.max(maxDiff, Math.abs(heights[i][j]-heights[i][j-1]));
            }
        }
        return maxDiff;
    }
    public boolean isPossibleDFS(int i, int j, int mid, int[][] heights, boolean[][] visited){
        if(i==r-1 && j==c-1) return true;
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && Math.abs(heights[i][j]-heights[adjRow][adjCol])<=mid){
                if(isPossibleDFS(adjRow, adjCol, mid, heights, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {
        r = heights.length;
        c = heights[0].length;

        int left=0, right=getRange(heights);

        int result = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            boolean[][] visited = new boolean[r][c];
            if(isPossibleDFS(0, 0, mid, heights, visited)){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }
}