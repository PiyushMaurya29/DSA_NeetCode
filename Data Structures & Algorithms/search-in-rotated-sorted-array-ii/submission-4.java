class Solution {
    public boolean binarySearch(int left, int right, int[] nums, int target){
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return false;
    }
    public int getPivotIndex(int[] nums){
        // This function returns the leftmost minimum value index
        int n = nums.length;
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        int left=0, right=nums.length-1;
        while(left <= right){
            int mid = left + (right-left) / 2;
            
            if(nums[left]==nums[mid] && nums[mid]==nums[right]){
                if(nums[left] < minValue){
                    minValue = nums[left];
                    minIndex = left;
                }
                left++;
                right--;
                continue;
            }
            
            if(nums[left] <= nums[mid]){
                if(nums[left] < minValue){
                    minValue = nums[left];
                    minIndex = left;
                }
                left = mid + 1;
            }
            else{
                if(nums[mid] <= minValue){
                    minValue = nums[mid];
                    minIndex = mid;
                }
                right = mid - 1;
            }
        }
        return minIndex;
    }
    public boolean search(int[] nums, int target) {
        // int n = nums.length;
        // int left=0, right=n-1;

        // while(left <= right){
        //     int mid = left + (right-left) / 2;

        //     if(nums[mid] == target){
        //         return true;
        //     }
        //     if(nums[left]==nums[mid] && nums[mid]==nums[right]){
        //         left++;
        //         right--;
        //         continue;
        //     }

        //     if(nums[left] <= nums[mid]){
        //         if(target>=nums[left] && target<=nums[mid]){
        //             right = mid - 1;
        //         }
        //         else left = mid + 1;
        //     }
        //     else{
        //         if(target>=nums[mid] && target<=nums[right]){
        //             left = mid + 1;
        //         }
        //         else right = mid - 1;
        //     }
        // }
        // return false;


        int n = nums.length;
        int pivotIndex = getPivotIndex(nums); // Minimum leftmost index
        return binarySearch(0, pivotIndex-1, nums, target) || binarySearch(pivotIndex, n-1, nums, target);

    }
}