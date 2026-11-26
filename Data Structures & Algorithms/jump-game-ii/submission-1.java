class Solution {
    public int solve(int index, int[] nums){
        if(index >= nums.length-1) return 0;
        int minJumps = Integer.MAX_VALUE;
        for(int i=index+1 ; i<=Math.min(index+nums[index], nums.length-1) ; i++){
            if(nums[index]==0) continue;
            int jumps = 1 + solve(i, nums);
            minJumps = Math.min(jumps, minJumps);
        }
        return minJumps;
    }
    public int jump(int[] nums) {
        return solve(0, nums);
    }
}
