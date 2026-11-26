class Solution {
    public boolean solve(int index, String s, Set<String> wordSet){
        if(index >= s.length()){
            return true;
        }
        for(int i=index ; i<s.length() ; i++){
            String str = s.substring(index, i+1);
            if(wordSet.contains(str) && solve(i+1, s, wordSet)){
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for(var w : wordDict){
            wordSet.add(w);
        }
        return solve(0, s, wordSet);
    }
}
