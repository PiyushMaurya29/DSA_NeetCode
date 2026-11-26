class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        // int length = 0;
        int n = s.length();
        int i = n-1;
        while(s.charAt(i) != ' '){
            i--;
        }
        return n-i-1;
    }
}