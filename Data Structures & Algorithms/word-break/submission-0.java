class Solution {
    public boolean solve(int index, String s, Set<String> set){
        if(index >= s.length()){
            return true;
        }
        for(int i=index+1 ; i<=s.length() ; i++){
            String str = s.substring(index, i);
            if(set.contains(str)){
                if(solve(i, s, set)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(var w : wordDict){
            set.add(w);
        }
        return solve(0, s, set);
    }
}
