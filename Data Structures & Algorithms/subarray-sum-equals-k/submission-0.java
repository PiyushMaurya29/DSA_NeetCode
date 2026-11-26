class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for(int i=0 ; i<n ; i++){
            int sum = 0;
            for(int j=i ; j<n ; j++){
                if(sum == k){
                    result++;
                }
            }
        }
        return result;
    }
}