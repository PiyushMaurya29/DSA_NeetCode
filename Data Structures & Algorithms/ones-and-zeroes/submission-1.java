class Solution {
    public int[] getCount(String str){
        int count0=0, count1=0;
        for(int i=0 ; i<str.length() ; i++){
            if(str.charAt(i) == '0') count0++;
            else count1++;
        }
        return new int[]{count0, count1};
    }

    Integer[][][] dp;
    public int solve(int index, String[] strs, int m, int n){
        if(index >= strs.length){
            return 0;
        }
        if(dp[index][m][n] != null){
            return dp[index][m][n];
        }

        int[] count = getCount(strs[index]);
        int take = 0;
        if(count[0]<=m && count[1]<=n){
            take = 1 + solve(index+1, strs, m-count[0], n-count[1]);
        }
        int notTake = solve(index+1, strs, m, n);
        return dp[index][m][n] = Math.max(take, notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length+1][m+1][n+1];
        return solve(0, strs, m, n);
    }
}