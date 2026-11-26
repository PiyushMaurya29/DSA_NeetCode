class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1 ; j<n ; j++){
                for(int k=j+1 ; k<n ; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
