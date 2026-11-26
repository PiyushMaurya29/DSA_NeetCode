class Solution {
    public boolean isValid(StringBuilder sb){
        int open = 0;
        for(char c : sb.toString().toCharArray()){
            if(c == '(') open++;
            else{
                if(open > 0) open--;
                else return false;
            }
        }
        return open == 0;
    }
    public boolean solve(int index, String s, StringBuilder sb){
        if(index >= s.length()){
            return isValid(sb);
        }
        if(s.charAt(index) == '*'){
            sb.append("(");
            boolean open = solve(index+1, s, sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            boolean close = solve(index+1, s, sb);
            sb.deleteCharAt(sb.length()-1);
            boolean skip = solve(index+1, s, sb);
            return open || close || skip;
        }
        else{
            sb.append(s.charAt(index));
            boolean ans = solve(index+1, s, sb);
            sb.deleteCharAt(sb.length()-1);
            return ans;
        }
    }
    public boolean solve(int index, int open, String s, Boolean[][] dp){
        if(index >= s.length()){
            return open == 0;
        }
        if(dp[index][open] != null){
            return dp[index][open];
        }
        if(s.charAt(index) == '('){
            return dp[index][open] = solve(index+1, open+1, s, dp);
        }
        else if(s.charAt(index) == ')'){
            return dp[index][open] = solve(index+1, open-1, s, dp);
        }
        else{
            boolean openCase = solve(index+1, open+1, s, dp);
            boolean closeCase = solve(index+1, open-1, s, dp);
            boolean skipCase = solve(index+1, open, s, dp);
            return dp[index][open] = openCase || closeCase || skipCase;
        }
    }
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()+1][s.length()+1];
        return solve(0, 0, s, dp);

        // return solve(0, s, new StringBuilder());
    }
}
