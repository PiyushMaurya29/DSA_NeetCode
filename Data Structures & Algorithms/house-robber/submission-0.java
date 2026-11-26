class Solution {
    public int solve(int index, int[] nums){
        if(index >= nums.length) return 0;
        int take = nums[index] + solve(index+2, nums);
        int notTake = solve(index+1, nums);
        return Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        return solve(0, nums);
    }
}
