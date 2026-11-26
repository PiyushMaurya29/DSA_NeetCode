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
    public boolean checkValidString(String s) {
        return solve(0, s, new StringBuilder());
    }
}
