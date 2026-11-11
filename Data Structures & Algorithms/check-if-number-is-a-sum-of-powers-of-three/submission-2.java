class Solution {
    Map<String, Boolean> dpMap = new HashMap<>();
    public boolean solve(int index, List<Integer> list, int target){
        if(target == 0) return true;
        if(target<0 || index>=list.size()){
            return false;
        }

        String key = index+","+target;
        if(dpMap.containsKey(key)){
            return dpMap.get(key);
        }
        
        boolean take = solve(index+1, list, target-list.get(index));
        boolean notTake = solve(index+1, list, target);
        boolean result = (take || notTake);
        dpMap.put(key, result);
        return result;
    }
    public boolean checkPowersOfThree(int n) {
        List<Integer> list = new ArrayList<>();
        int powOf3 = 1;

        while(powOf3 <= n){
            list.add(powOf3);
            powOf3 *= 3;
        }
        // Boolean[][] dp = new Boolean[list.size()+1][n+1];
        return solve(0, list, n);
    }
}
