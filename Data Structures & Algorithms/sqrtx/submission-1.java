class Solution {
    public int mySqrt(int x) {
        for(int i=x ; i>=0 ; i--){
            long square = i*i;
            if(square <= x){
                return i;
            }
        }
        return -1;
    }
}