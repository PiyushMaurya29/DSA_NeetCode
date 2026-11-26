class Solution {
    public int[] getRange(int[] piles){
        int minEle = Integer.MAX_VALUE;
        int sum = 0;
        for(int p : piles){
            minEle = Math.min(minEle, p);
            sum += p;
        }
        return new int[]{minEle, sum};
    }
    public boolean isPossible(int speed, int[] piles, int h){
        int time = 0;
        for(int p : piles){
            time += Math.ceil((double)p/speed);
        }
        return time <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int[] range = getRange(piles);
        int left = range[0];
        int right = range[1];

        int result = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, piles, h)){
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result;
    }
}
