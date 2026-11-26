class Solution {
    public boolean solve(int i, String s1, int j, String s2, int k, String s3){
        if(k == s3.length()){
            return true;
        }
        if(i >= s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j >= s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }

        boolean check1 = false;
        if(s1.charAt(i) == s3.charAt(k)){
            check1 = solve(i+1, s1, j, s2, k+1, s3);
        }
        boolean check2 = false;
        if(s2.charAt(j) == s3.charAt(k)){
            check2 = solve(i, s1, j+1, s2, k+1, s3);
        }
        return check1 || check2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return solve(0, s1, 0, s2, 0, s3);
    }
}
