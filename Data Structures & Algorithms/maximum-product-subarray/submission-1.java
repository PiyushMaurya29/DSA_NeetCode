class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;

        int leftProduct = 1;
        int rightProduct = 1;
        for(int i=0 ; i<n ; i++){
            leftProduct *= nums[i];
            result = Math.max(result, leftProduct);
            if(leftProduct == 0) leftProduct = 1;

            rightProduct = nums[n-i-1];
            result = Math.max(result, rightProduct);
            if(rightProduct == 0) rightProduct = 1;
        }
        return result;


        // int n = nums.length;
        // int result = Integer.MIN_VALUE;
        // int leftProduct = 1;
        // for(int i=0 ; i<n ; i++){
        //     leftProduct *= nums[i];
        //     result = Math.max(result, leftProduct);
        //     if(leftProduct == 0) leftProduct = 1;
        // }
        // int rightProduct = 1;
        // for(int i=n-1 ; i>=0 ; i--){
        //     rightProduct *= nums[i];
        //     result = Math.max(result, rightProduct);
        //     if(rightProduct == 0) rightProduct = 1;
        // }
        // return result;
    }
}
