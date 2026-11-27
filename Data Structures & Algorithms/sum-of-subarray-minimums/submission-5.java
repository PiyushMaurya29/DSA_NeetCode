class Solution {
    public int[] getNextSmallerElement(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1 ; i>=0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            // if(stack.isEmpty()) nse[i] = n;
            // else nse[i] = stack.peek();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }
    public int[] getPrevSmallerElement(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            // if(stack.isEmpty()) pse[i] = -1;
            // else pse[i] = stack.peek();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public int solve(int[] arr){
        final int MOD = 1000000007;
        int n = arr.length;

        int[] nse = new int[n];
        Stack<Integer> nStack = new Stack<>();
        int[] pse = new int[n];
        Stack<Integer> pStack = new Stack<>();
        for(int i=0 ; i<n ; i++){
            while(!pStack.isEmpty() && arr[pStack.peek()]>=arr[i]){
                pStack.pop();
            }
            if(pStack.isEmpty()) pse[i] = -1;
            else pse[i] = pStack.peek();
            pStack.push(i);


            int lastIndex = n-i-1;
            while(!nStack.isEmpty() && arr[nStack.peek()]>arr[lastIndex]){
                nStack.pop();
            }
            if(nStack.isEmpty()) nse[lastIndex] = n;
            else nse[lastIndex] = nStack.peek();
            nStack.push(lastIndex);
        }

        int result = 0;
        for(int i=0 ; i<n ; i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            int contribution = arr[i] * (left * right);
            result = (result + contribution) % MOD;
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        return solve(arr);



        // final int MOD = 1000000007;
        // int n = arr.length;
        // int[] nse = getNextSmallerElement(arr);
        // int[] pse = getPrevSmallerElement(arr);
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int left = i-pse[i];
        //     int right = nse[i]-i;

        //     int contribution = arr[i] * left * right;
        //     result = (result + contribution) % MOD;
        // }
        // return result;

        


        // int n = arr.length;
        // final int MOD = 1000000007;
        // int result = 0;
        // for(int i=0 ; i<n ; i++){
        //     int currMin = arr[i];
        //     for(int j=i ; j<n ; j++){
        //         currMin = Math.min(currMin, arr[j]);
        //         result = (result + currMin) % MOD;
        //     }
        // }
        // return result;

    }
}
