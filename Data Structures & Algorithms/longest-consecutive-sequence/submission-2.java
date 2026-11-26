class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        int maxLength = 0;
        int length = 1;
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == 1+nums[i-1]) length++;
            else length = 1;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;

        // Set<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // int maxLength = 0;
        // for(int num : nums){
        //     int length = 1;
        //     int curr = num;
        //     while(set.contains(curr+1)){
        //         length++;
        //         curr++;
        //     }
        //     maxLength = Math.max(maxLength, length);
        // }
        // return maxLength;
    }
}
