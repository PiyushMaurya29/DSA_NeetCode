class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        String str = n+"";
        for(char c : str.toCharArray()){
            if(c == '1') result++;
        }
        return result;
    }
}
