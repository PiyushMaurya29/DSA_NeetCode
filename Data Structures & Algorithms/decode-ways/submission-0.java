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
    public int numDecodings(String s) {
        result = 0;
        solve(0, new ArrayList<>(), s);
        return result;
    }
}
