class Solution {
    public int solve(int start, int end, int[] nums, int[] dp){
        if(start > end) return 0;
        if(dp[start] != -1){
            return dp[start];
        }
        int take = nums[start] + solve(start+2, end, nums, dp);
        int notTake = solve(start+1, end, nums, dp);
        return dp[start] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int result1 = solve(0, n-2, nums, dp);
        Arrays.fill(dp, -1);
        int result2 = solve(1, n-1, nums, dp);
        return Math.max(result1, result2);
    }
}
