class Solution {
    int totalCount;
    public boolean solve(int left, int right, int[] piles, boolean aliceTurn, int aliceCount){
        if(left > right){
            int bobCount = totalCount - aliceCount;
            return aliceCount > bobCount;
        }
        if(aliceTurn){
            boolean takeFirst = solve(left+1, right, piles, !aliceTurn, aliceCount+piles[left]);
            boolean takeLast = solve(left, right-1, piles, !aliceTurn, aliceCount+piles[right]);
            return takeFirst || takeLast;
        }
        else{
            boolean takeFirst = solve(left+1, right, piles, !aliceTurn, aliceCount);
            boolean takeLast = solve(left, right-1, piles, !aliceTurn, aliceCount);
            return takeFirst || takeLast;
        }
    }
    public boolean stoneGame(int[] piles) {
        // return true;
        totalCount = 0;
        for(int p : piles){
            totalCount += p;
        }
        return solve(0, piles.length-1, piles, true, 0);
    }
}