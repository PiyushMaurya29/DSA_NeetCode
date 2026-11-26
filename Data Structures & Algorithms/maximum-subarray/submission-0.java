class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        for(int i=0 ; i<n ; i++){
            int sum = 0;
            for(int j=i ; j<n ; j++){
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
