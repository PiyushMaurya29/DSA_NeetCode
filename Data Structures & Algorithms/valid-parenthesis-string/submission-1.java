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
    public boolean solve(int index, int open, String s){
        if(index >= s.length()){
            return open == 0;
        }
        if(s.charAt(index) == '('){
            return solve(index+1, open+1, s);
        }
        else if(s.charAt(index) == ')'){
            return solve(index+1, open-1, s);
        }
        else{
            boolean openCase = solve(index+1, open+1, s);
            boolean closeCase = solve(index+1, open-1, s);
            boolean skipCase = solve(index+1, open, s);
            return openCase || closeCase || skipCase;
        }
    }
    public boolean checkValidString(String s) {
        return solve(0, 0, s);

        // return solve(0, s, new StringBuilder());
    }
}
