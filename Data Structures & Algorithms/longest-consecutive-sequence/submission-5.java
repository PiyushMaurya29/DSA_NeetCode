class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxLength = 1;
        for(int ele : set){
            // If this element is the starting element
            if(!set.contains(ele-1)){
                int length = 1;
                int curr = ele;
                while(set.contains(curr+1)){
                    curr++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
        

        // TC => O(n*log(n))
        // int n = nums.length;
        // if(n==0 || n==1) return n;
        // Arrays.sort(nums);
        // int maxLength = 1;
        // int length = 1;
        // for(int i=1 ; i<n ; i++){
        //     if(nums[i] == nums[i-1]) continue;
        //     if(nums[i] == 1+nums[i-1]) length++;
        //     else length = 1;
        //     maxLength = Math.max(maxLength, length);
        // }
        // return maxLength;


        // TC => O(n^2)
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
