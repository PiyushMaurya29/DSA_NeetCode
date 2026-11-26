class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0 ; i<nums.length ; i++){
        //     if(map.containsKey(target-nums[i])){
        //         return new int[]{map.get(target-nums[i]), i};
        //     }
        //     map.put(nums[i], i);
        // }
        // return new int[]{-1, -1};

        int n = nums.length;
        int[][] pair = new int[n][2];
        for(int i=0 ; i<n ; i++){
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));
        int i=0, j=n-1;
        while(i < j){
            int sum = pair[i][0] + pair[j][0];
            if(sum == target){
                return new int[]{pair[i][1], pair[j][1]};
            }
            else if(sum > target) j--;
            else i++;
        }
        return new int[]{-1, -1};


        // int n = nums.length;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i+1 ; j<n ; j++){
        //         if(nums[i]+nums[j] == target){
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{-1, -1};
    }
}
