class Solution {
    public boolean isSorted(int start, int[] nums){
        int n = nums.length;
        for(int i=start ; i<start+n-1 ; i++){
            int currIndex = i%n;
            int nextIndex = (i+1)%n;
            if(nums[currIndex] > nums[nextIndex]){
                return false;
            }
        }
        return true;
    }
    public boolean check(int[] nums) {
        int n = nums.length;
        int minEle = Integer.MAX_VALUE;
        int minIndex = -1;

        int left=0, right=n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[left] <= nums[mid]){
                if(nums[left] < minEle){
                    minEle = nums[left];
                    minIndex = left;
                }
                left = mid + 1;
            }
            else{
                if(nums[mid] < minEle){
                    minEle = nums[mid];
                    minIndex = mid;
                }
                right = mid - 1;
            }
        }
        for(int i=minIndex ; i<minIndex+n-1 ; i++){
            int currIndex = i%n;
            int nextIndex = (i+1)%n;
            if(nums[currIndex] > nums[nextIndex]){
                return false;
            }
        }
        return true;


        // int n = nums.length;
        // for(int i=0 ; i<n ; i++){
        //     if(isSorted(i, nums)){
        //         return true;
        //     }
        // }
        // return false;
    }
}