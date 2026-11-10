class Solution {
    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        for(int i=0 ; i<k ; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int result = count;
        for(int i=k ; i<n ; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
            
            if(isVowel(s.charAt(i-k))){
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
        



        // int n = s.length();
        // int result = 0;
        // int count = 0;
        // int left = 0;

        // for(int right=0 ; right<n ; right++){
        //     if(isVowel(s.charAt(right))){
        //         count++;
        //     }
        //     if(right-left+1 > k){
        //         if(isVowel(s.charAt(left))){
        //             count--;
        //         }
        //         left++;
        //     }
        //     result = Math.max(result, count);
        // }
        // return result;



        // int n = s.length();
        // int result = 0;
        // int count = 0;
        // int left=0, right=0;
        // while(right < n){
        //     if(isVowel(s.charAt(right))){
        //         count++;
        //     }
        //     if(right-left+1 > k){
        //         if(isVowel(s.charAt(left))){
        //             count--;
        //         }
        //         left++;
        //     }
        //     result = Math.max(result, count);
        //     right++;
        // }
        // return result;



        // int n = s.length();
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int count = 0;
        //     for(int j=i ; j<n ; j++){
        //         if(j-i+1 > k) break;
        //         if(isVowel(s.charAt(j))){
        //             count++;
        //         }
        //         result = Math.max(result, count);
        //     }
        // }
        // return result;

    }
}
