class Solution {
    public StringBuilder getMultiply(String s, char c){
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i=s.length()-1 ; i>=0 ; i--){
            int product = carry + ((s.charAt(i)-'0') * (c-'0'));
            result.append(product%10);
            carry = product/10;
        }
        if(carry > 0) result.append(carry);
        return result.reverse();
    }
    public StringBuilder getAddition(StringBuilder s1, StringBuilder s2){
        int i=s1.length()-1, j=s2.length()-1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while(i>=0 && j>=0){
            int sum = carry + s1.charAt(i)-'0' + s2.charAt(j)-'0';
            result.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        while(i >= 0){
            int sum = carry + s1.charAt(i)-'0';
            result.append(sum%10);
            carry = sum/10;
            i--;
        }
        while(j >= 0){
            int sum = carry + s2.charAt(j)-'0';
            result.append(sum%10);
            carry = sum/10;
            j--;
        }
        if(carry > 0) result.append(carry);
        return result.reverse();
    }
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        StringBuilder countZero = new StringBuilder();
        List<StringBuilder> list = new ArrayList<>();

        for(int i=n-1 ; i>=0 ; i--){
            StringBuilder sb = getMultiply(num1, num2.charAt(i));

            sb.append(countZero);
            list.add(sb);

            countZero.append("0");
        }

        StringBuilder result = new StringBuilder();
        for(var sb : list){
            result = getAddition(result, sb);
        }
        return result.toString();
    }
}
