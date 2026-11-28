class Solution {
    int r, c;
    Integer[][][] dp;
    public int solve(int row, int c1, int c2, int[][] grid){
        if(c1<0 || c1>=c || c2<0 || c2>=c){
            return Integer.MIN_VALUE;
        }
        if(row >= r) return 0;

        if(dp[row][c1][c2] != null){
            return dp[row][c1][c2];
        }

        int case1 = solve(row+1, c1-1, c2-1, grid);
        int case2 = solve(row+1, c1-1, c2, grid);
        int case3 = solve(row+1, c1-1, c2+1, grid);
        int case4 = solve(row+1, c1, c2-1, grid);
        int case5 = solve(row+1, c1, c2, grid);
        int case6 = solve(row+1, c1, c2+1, grid);
        int case7 = solve(row+1, c1+1, c2-1, grid);
        int case8 = solve(row+1, c1+1, c2, grid);
        int case9 = solve(row+1, c1+1, c2+1, grid);

        int best = Math.max(Math.max(case1, case2), Math.max(case2, case3));
        best = Math.max(best, Math.max(case4, case5));
        best = Math.max(best, Math.max(case6, case7));
        best = Math.max(best, Math.max(case8, case9));

        if(best == Integer.MIN_VALUE){
            return best;
        }
        int result = ((c1==c2) ? grid[row][c1] : grid[row][c1]+grid[row][c2]) + best;
        return dp[row][c1][c2] = result;
    }

    public int solve2(int row, int c1, int c2, int[][] grid){
        if(c1<0 || c1>=c || c2<0 || c2>=c){
            return Integer.MIN_VALUE;
        }
        if(row >= r) return 0;

        if(dp[row][c1][c2] != null){
            return dp[row][c1][c2];
        }

        int result = Integer.MIN_VALUE;
        for(int i=-1 ; i<=1 ; i++){
            for(int j=-1 ; j<=1 ; j++){
                int ans = solve2(row+1, c1+i, c2+j, grid);
                result = Math.max(result, ans);
            }
        }
        if(result == Integer.MIN_VALUE) return result;
        return dp[row][c1][c2] = result + (c1==c2 ? grid[row][c1] : grid[row][c1]+grid[row][c2]); 
    }
    public int cherryPickup(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        dp = new Integer[r+1][c+1][c+1];
        return solve2(0, 0, c-1, grid);


        // r = grid.length;
        // c = grid[0].length;
        // dp = new Integer[r+1][c+1][c+1];
        // return solve(0, 0, c-1, grid);
    }
}
