class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int incLength = 1;
        int decLength = 1;

        int result = 1;
        for(int i=1 ; i<n ; i++){
            if(nums[i] > nums[i-1]) incLength++;
            else incLength = 1;
            if(nums[i] < nums[i-1]) decLength++;
            else decLength = 1;

            result = Math.max(result, Math.max(incLength, decLength));
        }
        return result;
    }
}