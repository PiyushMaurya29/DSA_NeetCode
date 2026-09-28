class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                result += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return result;



        // int n = nums.length;
        // int resultCount = 0;
        // for(int i=0 ; i<n ; i++){
        //     int sum = 0;
        //     for(int j=i ; j<n ; j++){
        //         sum += nums[j];
        //         if(sum%k == 0){
        //             resultCount++;
        //         }
        //     }
        // }
        // return resultCount;
    }
}