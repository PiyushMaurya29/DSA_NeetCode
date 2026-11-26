class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int result = 0;
        int rightMaxIndex = n-1;
        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i] > nums[rightMaxIndex]){
                rightMaxIndex = i;
            }
            result = Math.max(result, rightMaxIndex-i);
        }
        return result;
        

        // int n = nums.length;
        // int result = 0;
        // int leftMinIndex = 0;
        // for(int i=0 ; i<n ; i++){
        //     if(nums[i] < nums[leftMinIndex]){
        //         leftMinIndex = i;
        //     }
        //     result = Math.max(result, i-leftMinIndex);
        // }
        // return result;



        // int n = nums.length;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i+1 ; j<n ; j++){
        //         if(nums[i] <= nums[j]){
        //             result = Math.max(result, j-i);
        //         }
        //     }
        // }
        // return result;
    }
}
