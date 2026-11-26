class Solution {
    class Node{
        Node[] children = new Node[26];
        boolean isEnd = true; 
    }
    Node root = new Node();
    public void insertIntoTrie(String s){
        Node node = root;
        for(int i=0 ; i<s.length() ; i++){
            int index = s.charAt(i)-'a';
            if(node.children[index] == null){
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    public boolean searchIntoTrie(int left, int right, String s){
        Node node = root;
        for(int i=left ; i<=right ; i++){
            int index = s.charAt(i)-'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }
    public boolean solve(int index, String s, Set<String> wordSet, Boolean[] dp){
        if(index >= s.length()){
            return true;
        }
        if(dp[index] != null){
            return dp[index];
        }
        for(int i=index ; i<s.length() ; i++){
            // String str = s.substring(index, i+1);
            // if(wordSet.contains(str) && solve(i+1, s, wordSet, dp)){
            //     return dp[index] = true;
            // }
            if(searchIntoTrie(index, i, s) && solve(i+1, s, wordSet, dp)){
                return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        // for(var w : wordDict){
        //     wordSet.add(w);
        // }
        for(var w : wordDict){
            insertIntoTrie(w);
        }
        Boolean[] dp = new Boolean[s.length()+1];
        return solve(0, s, wordSet, dp);
    }
}
