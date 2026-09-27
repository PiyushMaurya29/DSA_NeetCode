class Solution {
    public int solve(int[] nums, int target, int[] dp){
        if(target == 0) return 1;
        if(target < 0) return 0;

        if(dp[target] != -1){
            return dp[target];
        }
        
        int result = 0;
        for(int num : nums){
            result += solve(nums, target-num, dp);
        }
        return dp[target] = result;
    }
    public int solve(int index, int[] nums, int target, int[][] dp){
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(index >= nums.length) return 0;

        if(dp[index][target] != -1){
            return dp[index][target];
        }

        int take = solve(0, nums, target-nums[index], dp);
        int notTake = solve(index+1, nums, target, dp);
        return dp[index][target] = (take + notTake);
    }
    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, nums, target, dp);


        // int[] dp = new int[target+1];
        // Arrays.fill(dp, -1);
        // return solve(nums, target, dp);
    }
}