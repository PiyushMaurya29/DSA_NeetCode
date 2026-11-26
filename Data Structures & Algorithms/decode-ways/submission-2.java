class Solution {
    int result;
    public boolean isValid(List<String> list){
        for(var l : list){
            if(l.charAt(0)=='0' || l.length()>2){
                return false;
            }
            int value = Integer.parseInt(l);
            if(value > 26) return false;
        }
        return true;
    }
    public void solve(int index, List<String> list, String s){
        if(index >= s.length()){
            if(isValid(list)){
                result++;
            }
            return;
        }
        for(int i=index ; i<s.length() ; i++){
            String str = s.substring(index, i+1);
            list.add(str);
            solve(i+1, list, s);
            list.remove(list.size()-1);
        }
    }

    public int solve(int index, String s, int[] dp){
        if(index >= s.length()){
            return 1;
        }
        if(s.charAt(index) == '0') return 0;

        if(dp[index] != -1){
            return dp[index];
        }

        int takeOneChar = solve(index+1, s, dp);
        int takeTwoChar = 0;
        if(index+1<s.length() && s.charAt(index+1)<'7'){
            takeTwoChar = solve(index+2, s, dp);
        }
        return dp[index] = (takeOneChar+takeTwoChar);
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);


        // result = 0;
        // solve(0, new ArrayList<>(), s);
        // return result;
    }
}
