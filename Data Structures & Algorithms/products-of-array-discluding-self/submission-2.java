class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        int prefix = 1;
        for(int i=1 ; i<n ; i++){
            result[i] = prefix * nums[i-1];
            prefix *= nums[i];
        }
        int suffix = 1;
        for(int i=n-1 ; i>=0 ; i--){
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;


        // int n = nums.length;
        // int[] rightProduct = new int[n];
        // rightProduct[n-1] = nums[n-1];
        // for(int i=n-2 ; i>=0 ; i--){
        //     rightProduct[i] = nums[i] * rightProduct[i+1];
        // } 
        // int[] result = new int[n];
        // result[0] = rightProduct[1];
        // int leftProduct = nums[0];
        // for(int i=1 ; i<n-1 ; i++){
        //     result[i] = leftProduct * rightProduct[i+1];
        //     leftProduct *= nums[i];
        // }
        // result[n-1] = leftProduct;
        // return result;

        // int n = nums.length;
        // int[] result = new int[n];
        // for(int i=0 ; i<n ; i++){
        //     int product = 1;
        //     for(int j=0 ; j<n ; j++){
        //         if(i == j) continue;
        //         product *= nums[j];
        //     }
        //     result[i] = product;
        // }
        // return result;
    }
}  
