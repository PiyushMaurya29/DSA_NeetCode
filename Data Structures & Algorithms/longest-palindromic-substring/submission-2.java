class Solution {
    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    int n;
    public void checkPalindrome(int i, int j, String s, int[] startIndex, int[] maxLength){
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(j-i-1 > maxLength[0]){
            maxLength[0] = j-i-1;
            startIndex[0] = i+1;
        }
    }
    public String longestPalindrome(String s) {
        n = s.length();
        int[] startIndex = {0};
        int[] maxLength = {0};

        for(int i=1 ; i<n ; i++){
            checkPalindrome(i, i-1, s, startIndex, maxLength);
            checkPalindrome(i, i, s, startIndex, maxLength);
        }
        return s.substring(startIndex[0], startIndex[0]+maxLength[0]);

        // int n = s.length();
        // int startIndex = 0;
        // int maxLength = 1;

        // for(int k=1 ; k<n ; k++){
        //     int i=k-1, j=k;
        //     while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
        //         i--;
        //         j++;
        //     }
        //     if(j-i-1>maxLength){
        //         maxLength = j-i-1;
        //         startIndex = i+1;
        //     }

        //     i=k;
        //     j=k;
        //     while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
        //         i--;
        //         j++;
        //     }
        //     if(j-i-1>maxLength){
        //         maxLength = j-i-1;
        //         startIndex = i+1;
        //     }
        // }
        // return s.substring(startIndex, startIndex+maxLength);


        // int n = s.length();
        // int startIndex = -1;
        // int maxLength = 0;
        // for(int i=0 ; i<n ; i++){
        //     for(int j=i ; j<n ; j++){
        //         if(j-i+1>maxLength && isPalindrome(i, j, s)){
        //             startIndex = i;
        //             maxLength = j-i+1;
        //         }
        //     }
        // }

        // return s.substring(startIndex, startIndex+maxLength);
    }
}
