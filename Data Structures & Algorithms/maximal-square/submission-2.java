class Solution {
    public int getMaxSide(int[] height){
        int n = height.length;
        int maxSide = 0;
        for(int i=0 ; i<n ; i++){
            int leftMin = -1;
            for(int j=i-1 ; j>=0 ; j--){
                if(height[j] < height[i]){
                    leftMin = j;
                    break;
                }
            }
            int rightMin = n;
            for(int j=i+1 ; j<n ; j++){
                if(height[j] < height[i]){
                    rightMin = j;
                    break;
                }
            }

            int width = rightMin-leftMin-1;
            int side = Math.min(height[i], width);
            maxSide = Math.max(maxSide, side);
        }
        return maxSide;
    }

    public int getMaxSideStack(int[] height){
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n]; // previous smaller element index
        for(int i=0 ; i<n ; i++){
            while(!stack.isEmpty() && height[stack.peek()]>=height[i]){
                stack.pop();
            }
            // if(stack.isEmpty()) pse[i] = -1;
            // else pse[i] = stack.peek();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        // stack = new ArrayDeque<>();
        int[] nse = new int[n]; // next smaller element index
        for(int i=n-1 ; i>=0 ; i--){
            while(!stack.isEmpty() && height[stack.peek()]>=height[i]){
                stack.pop();
            }
            // if(stack.isEmpty()) nse[i] = n;
            // else nse[i] = stack.peek();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int maxSide = 0;
        for(int i=0 ; i<n ; i++){
            int width = nse[i]-pse[i]-1;
            int side = Math.min(height[i], width);
            maxSide = Math.max(maxSide, side);
        }
        return maxSide;
    }
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int result = 0;

        int[] height = new int[c];
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }
                else height[j] = 0;
            }
            // int side = getMaxSide(height); // n^2
            int side = getMaxSideStack(height);
            result = Math.max(result, side*side);
        }
        return result;
    }
}