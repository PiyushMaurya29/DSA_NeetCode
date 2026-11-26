class Solution {
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        return max;
    }
    public int singleNumber(int[] nums) {
        int max = getMax(nums);
        int[] freq = new int[max+1];
        for(int num : nums){
            freq[num]++;
        }
        for(int i=0 ; i<=max ; i++){
            if(freq[i] == 1){
                return i;
            }
        }
        return max;
    }
}
