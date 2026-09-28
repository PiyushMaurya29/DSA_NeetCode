class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        
        int resultCount = 0;
        for(int i=0 ; i<n ; i++){
            int sum = 0;
            for(int j=i ; j<n ; j++){
                sum += nums[j];
                if(sum%k == 0){
                    resultCount++;
                }
            }
        }
        return resultCount;
    }
}