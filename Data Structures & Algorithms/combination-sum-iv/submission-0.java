class Solution {
    public int solve(int[] nums, int target){
        if(target == 0) return 1;
        if(target < 0) return 0;
        
        int result = 0;
        for(int num : nums){
            result += solve(nums, target-num);
        }
        return result;
    }
    public int combinationSum4(int[] nums, int target) {
        return solve(nums, target);
    }
}