class Solution {
    public int solve(int left, int right, String s){
        if(left > right) return 0;
        if(left == right) return 1;
        if(s.charAt(left) == s.charAt(right)){
            return 2 + solve(left+1, right-1, s);
        }
        else{
            int skipFirst = solve(left+1, right, s);
            int skipLast = solve(left, right-1, s);
            return Math.max(skipFirst, skipLast);
        }
    }
    public int longestPalindromeSubseq(String s) {
        return solve(0, s.length()-1, s);
    }
}