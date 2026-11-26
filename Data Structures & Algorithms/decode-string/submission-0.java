class Solution {
    public boolean checkIsInteger(String s){
        for(char c : s.toCharArray()){
            if(!(c>='0' && c<='9')){
                return false;
            }
        }
        return true;
    }
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ']'){
                StringBuilder str = new StringBuilder();
                while(!stack.peek().equals("[")){
                    str.append(stack.pop());
                }
                str.reverse();
                stack.pop(); // Remove "["

                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && checkIsInteger(stack.peek())){
                    num.append(stack.pop());
                }
                num.reverse();

                StringBuilder ans = new StringBuilder();
                for(int i=1 ; i<=Integer.parseInt(num.toString()) ; i++){
                    ans.append(str);
                }
                stack.push(ans.toString());
            }
            else stack.push(c+"");
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}