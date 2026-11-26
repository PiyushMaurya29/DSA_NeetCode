class Solution {
    List<List<Integer>> result;
    Set<List<Integer>> set;
    public void solve(int index, List<Integer> list, int[] arr, int target){
        if(index >= arr.length){
            if(target == 0){
                if(!set.contains(list)){
                    set.add(new ArrayList<>(list));
                    result.add(new ArrayList<>(list));
                }
            }
            return;
        }
        list.add(arr[index]);
        solve(index+1, list, arr, target-arr[index]);
        list.remove(list.size()-1);
        solve(index+1, list, arr, target);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        set = new HashSet<>();

        solve(0, new ArrayList<>(), candidates, target);
        return result;

    }
}
