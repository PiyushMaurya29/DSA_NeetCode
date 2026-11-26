class Solution {
    public int solve(int index, int[] prices, int canBuy){
        if(index >= prices.length) return 0;
        if(canBuy == 1){
            int buy = -prices[index] + solve(index+1, prices, 0);
            int notBuy = solve(index+1, prices, 1);
            return Math.max(buy, notBuy);
        }
        else{
            int sell = prices[index] + solve(index+1, prices, 1);
            int notSell = solve(index+1, prices, 0);
            return Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices) {
        return solve(0, prices, 1);
    }
}