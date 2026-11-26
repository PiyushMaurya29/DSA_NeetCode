class Solution {
    public int solve(int index, int[] coins, int amount){
        if(amount == 0) return 1;
        if(index >= coins.length || amount<0) return 0;
        int take = solve(index, coins, amount-coins[index]);
        int notTake = solve(index+1, coins, amount);
        return (take+notTake);
    }
    public int change(int amount, int[] coins) {
        return solve(0, coins, amount);
    }
}
