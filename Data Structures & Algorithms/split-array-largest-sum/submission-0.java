class Solution {
    public int solve(int index, int maxSum, int[] nums, int k){
        if(k < 0) return Integer.MAX_VALUE;
        if(index >= nums.length){
            return k==0 ? maxSum : Integer.MAX_VALUE;
        }
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=index ; i<nums.length ; i++){
            sum += nums[i];
            int ans = solve(i+1, Math.max(sum, maxSum), nums, k-1);
            if(ans != Integer.MAX_VALUE){
                result = Math.min(result, ans);
            }
        }
        return result;
    }
    public int splitArray(int[] nums, int k) {
        return solve(0, Integer.MIN_VALUE, nums, k);
    }
}