class Solution {
    public boolean solve(int i, String s, int j, String t, Boolean[][] dp){
        if(i == s.length()) return true;
        if(j == t.length()) return false;

        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = solve(i+1, s, j+1, t, dp);
        }
        else{
            return dp[i][j] = solve(i, s, j+1, t, dp);
        }
    }
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) return false;
        int index = 0;
        for(int i=0 ; i<t.length() ; i++){
            if(t.charAt(i) == s.charAt(index)){
                index++;
            }
            if(index == s.length()) return true;
        }
        return index==s.length();


        // if(t.length() < s.length()) return false;
        // int i=0, j=0;
        // while(i<s.length() && j<t.length()){
        //     if(s.charAt(i) == t.charAt(j)){
        //         i++;
        //     }
        //     j++;
        // }
        // return i==s.length();


        // if(t.length() < s.length()) return false;
        // Boolean[][] dp = new Boolean[s.length()][t.length()];
        // return solve(0, s, 0, t, dp);
    }
}