class Solution {
    public int findDuplicate(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i] == candidate){
                count++;
            }
            else{
                if(count > 1) count--;
                else{
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;


        // Arrays.sort(nums);
        // for(int i=1 ; i<nums.length ; i++){
        //     if(nums[i] == nums[i-1]){
        //         return nums[i];
        //     }
        // }
        // return -1;
    }
}
