class Solution {
    public boolean solve(int index, List<Integer> list, int target){
        if(target == 0) return true;
        if(target<0 || index>=list.size()){
            return false;
        }
        boolean take = solve(index+1, list, target-list.get(index));
        boolean notTake = solve(index+1, list, target);
        return (take || notTake);
    }
    public boolean checkPowersOfThree(int n) {
        List<Integer> list = new ArrayList<>();
        int powOf3 = 1;

        while(powOf3 <= n){
            list.add(powOf3);
            powOf3 *= 3;
        }

        return solve(0, list, n);
    }
}
