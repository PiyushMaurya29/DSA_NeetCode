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

    public int getSum(int topRow, int topCol, int botRow, int botCol, char[][] matrix){
        int sum = 0;
        for(int i=topRow ; i<=botRow ; i++){
            for(int j=topCol ; j<=botCol ; j++){
                if(matrix[i][j] == '1'){
                    sum++;
                }
            }
        }
        return sum;
    }
    public int getMaxSide(int topRow, int topCol, char[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        int side = 1;

        int botRow = topRow;
        int botCol = topCol;
        while(botRow<r && botCol<c){
            int currSide = botRow-topRow+1;
            int sum = currSide * currSide;
            if(getSum(topRow, topCol, botRow, botCol, matrix) < sum){
                return side-1;
            }
            botRow++;
            botCol++;

            side++;
        }
        return side-1;
    }
    public int getMaxSide(int topRow, int topCol, int[][] prefixSum){
        int r = prefixSum.length;
        int c = prefixSum[0].length;

        int botRow = topRow;
        int botCol = topCol;
        int side = 1;
        while(botRow<r && botCol<c){
            int currSide = botRow-topRow+1;
            int currSum = currSide * currSide;
            int sum = prefixSum[botRow][botCol];
            if(topRow>0) sum -= prefixSum[topRow-1][botCol];
            if(topCol>0) sum -= prefixSum[botRow][topCol-1];
            if(topRow>0 && topCol>0) sum += prefixSum[topRow-1][topCol-1];

            if(sum < currSum){
                return side-1;
            }
            botRow++;
            botCol++;
            side++;
        }
        return side-1;
    }
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] prefixSum = new int[r][c];
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                prefixSum[i][j] = matrix[i][j]-'0';
            }
        }
        for(int i=1 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }
        for(int i=0 ; i<r ; i++){
            for(int j=1 ; j<c ; j++){
                prefixSum[i][j] += prefixSum[i][j-1];
            }
        }
        int result = 0;
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(matrix[i][j] == '1'){
                    // int side = getMaxSide(i, j, matrix);
                    int side = getMaxSide(i, j, prefixSum);
                    result = Math.max(result, side*side);
                }
            }
        }
        return result;


        // int r = matrix.length;
        // int c = matrix[0].length;
        // int result = 0;
        // int[] height = new int[c];
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         if(matrix[i][j] == '1'){
        //             height[j]++;
        //         }
        //         else height[j] = 0;
        //     }
        //     // int side = getMaxSide(height); // n^2
        //     int side = getMaxSideStack(height);
        //     result = Math.max(result, side*side);
        // }
        // return result;
    }
}