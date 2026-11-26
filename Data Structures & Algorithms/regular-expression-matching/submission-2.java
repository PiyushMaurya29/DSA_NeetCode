class Solution {
    int m, n;
    public boolean solve(int i, String s, int j, String p){
        if(i==-1 && j==-1) return true;
        if(i==-1 || j==-1) return false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
            return solve(i-1, s, j-1, p);
        }
        else if(p.charAt(j)=='*'){
            boolean matchStar = solve(i-1, s, j, p);
            boolean skipStar = solve(i-1, s, j-1, p);
            boolean skip = solve(i-1, s, j-2, p);
            return matchStar || skipStar || skip;
        }
        else return false;
    }
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        return solve(m-1, s, n-1, p);
    }
}
