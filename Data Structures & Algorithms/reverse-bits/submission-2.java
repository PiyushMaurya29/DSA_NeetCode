class Solution {
    public int reverseBits(int n) {
        int result = 0;
        int count = 32;
        while(count-- > 0){
            int lastBit = n & 1;
            n >>= 1;
            result <<= 1;
            result = result | lastBit;
        }
        return result;


        // int result = 0;
        // for(int i=0 ; i<32 ; i++){
        //     int lastBit = n & 1;
        //     result <<= 1;
        //     result = result | lastBit;
        //     n >>= 1;
        // }
        // return result;
    }
}
