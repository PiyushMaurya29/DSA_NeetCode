class Solution {
    int result;
    int r, c;
    public void helper(int i, int j, int count, int[][] grid){
        if(i<0 || j<0 || grid[i][j]==-1) return;
        if(i==0 && j==0){
            result = Math.max(result, count);
            return;
        }
        int value = grid[i][j];
        grid[i][j] = 0;
        helper(i-1, j, count+value, grid);
        helper(i, j-1, count+value, grid);
        grid[i][j] = value;
    }
    public void solve(int i, int j, int count, int[][] grid){
        if(i>=r || j>=c || grid[i][j] == -1) return;
        if(i==r-1 && j==c-1){
            helper(i, j, count, grid);
            return;
        }
        int value = grid[i][j];
        grid[i][j] = 0;
        solve(i+1, j, count+value, grid);
        solve(i, j+1, count+value, grid);
        grid[i][j] = value;
    }
    public int cherryPickup(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        if(r==1 && c==1){
            if(grid[0][0] == -1) return 0;
            return grid[0][0];
        }
        result = 0;
        solve(0, 0, 0, grid);
        return result;
    }
}