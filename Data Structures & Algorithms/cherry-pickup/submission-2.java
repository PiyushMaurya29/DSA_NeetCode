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
    public int solve(int i1, int j1, int i2, int j2, int[][] grid){
        if(i1==r-1 && j1==c-1 && i2==r-1 && j2==c-1){
            return grid[i1][j1];
        }
        if(i1>=r || j1>=c || i2>=r || j2>=c || grid[i1][j1]==-1 || grid[i2][j2]==-1){
            return Integer.MIN_VALUE;
        }
        // int value = 0;
        // if(i1==i2 && j1==j2) value += grid[i1][j1];
        // else value = grid[i1][j1] + grid[i2][j2];

        int value = (i1==i2 && j1==j2) ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2];

        int case1 = solve(i1+1, j1, i2+1, j2, grid);
        int case2 = solve(i1+1, j1, i2, j2+1, grid);
        int case3 = solve(i1, j1+1, i2, j2+1, grid);
        int case4 = solve(i1, j1+1, i2+1, j2, grid);
        
        int result = Math.max(Math.max(case1, case2), Math.max(case3, case4));
        if(result == Integer.MIN_VALUE) return result;
        return value + result;
    }
    public int cherryPickup(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int result = solve(0, 0, 0, 0, grid);

        return result == Integer.MIN_VALUE ? 0 : result;

        // r = grid.length;
        // c = grid[0].length;
        // if(r==1 && c==1){
        //     if(grid[0][0] == -1) return 0;
        //     return grid[0][0];
        // }
        // result = 0;
        // solve(0, 0, 0, grid);
        // return result;
    }
}