class Solution {
    public int mySqrt(int x) {
        int left=0, right=x;
        int result = -1;
        while(left <= right){
            int mid = left + (right-left) / 2;
            int square = mid * mid;
            if(square <= x){
                result = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return result;


        // for(int i=x ; i>=0 ; i--){
        //     long square = i*i;
        //     if(square <= (long)x){
        //         return i;
        //     }
        // }
        // return -1;
    }
}