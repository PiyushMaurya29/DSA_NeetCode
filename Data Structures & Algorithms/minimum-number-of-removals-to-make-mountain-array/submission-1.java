class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftLIS = new int[n];
        Arrays.fill(leftLIS, 1);

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if(nums[i] > nums[j]){
                    leftLIS[i] = Math.max(leftLIS[i], 1+leftLIS[j]);
                }
            }
        }

        int[] rightLIS = new int[n];
        Arrays.fill(rightLIS, 1);
        for(int i=n-1 ; i>=0 ; i--){
            for(int j=n-1 ; j>i ; j--){
                if(nums[i] > nums[j]){
                    rightLIS[i] = Math.max(rightLIS[i], 1+rightLIS[j]);
                }
            }
        }

        int maxMountain = 0;
        for(int i=0 ; i<n ; i++){
            if(leftLIS[i]>1 && rightLIS[i]>1){
                maxMountain = Math.max(maxMountain, leftLIS[i]+rightLIS[i]-1);
            }
        }
        int removalCount = n - maxMountain;
        return removalCount;
    }
}
