class Solution {
    public int getLength(int index, int[] nums){
        int n = nums.length;

        int inc = 1;
        int incIndex = index;
        while(incIndex+1<n && nums[incIndex+1]>nums[incIndex]){
            inc++;
            incIndex++;
        }
        int dec = 1;
        int decIndex = index;
        while(decIndex+1<n && nums[decIndex+1]<nums[decIndex]){
            dec++;
            decIndex++;
        }
        return Math.max(inc, dec);
    }
    public int longestMonotonicSubarray(int[] nums) {
        // int n = nums.length;
        // if(n == 0) return 0;
        // int incLength = 1;
        // int decLength = 1;

        // int result = 1;
        // for(int i=1 ; i<n ; i++){
        //     if(nums[i] > nums[i-1]) incLength++;
        //     else incLength = 1;
        //     if(nums[i] < nums[i-1]) decLength++;
        //     else decLength = 1;

        //     result = Math.max(result, Math.max(incLength, decLength));
        // }
        // return result;


        int result = 1;
        for(int i=0 ; i<nums.length ; i++){
            int length = getLength(i, nums);
            result = Math.max(result, length);
        }
        return result;
    }
}