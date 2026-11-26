class Solution {
    int row, col;
    public int solve(int i, int j, int[][] grid){
        if(i==row-1 && j==col-1){
            return grid[i][j];
        }
        if(i>=row || j>=col){
            return Integer.MAX_VALUE;
        }
        int down = solve(i+1, j, grid);
        int right = solve(i, j+1, grid);
        return grid[i][j] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        return solve(0, 0, grid);
    }
}