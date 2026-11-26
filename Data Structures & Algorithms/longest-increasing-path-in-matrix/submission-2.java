class Solution {
    int r, c;
    int result;
    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void solveDFS(int i, int j, int[][] matrix, int pathLength){
        result = Math.max(result, pathLength);

        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && matrix[adjRow][adjCol]>matrix[i][j]){
                int oldValue = matrix[i][j];
                matrix[i][j] = -1;
                solveDFS(adjRow, adjCol, matrix, 1+pathLength);
                matrix[i][j] = oldValue; // BackTrack
            }
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;

        result = 0;

        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                solveDFS(i, j, matrix, 1);
            }
        }
        return result;
    }
}
