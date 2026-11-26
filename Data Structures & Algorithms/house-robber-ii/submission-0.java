class Solution {
    public int solve(int start, int end, int[] nums){
        if(start > end) return 0;
        int take = nums[start] + solve(start+2, end, nums);
        int notTake = solve(start+1, end, nums);
        return Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int result1 = solve(0, n-2, nums);
        int result2 = solve(1, n-1, nums);
        return Math.max(result1, result2);
    }
}
