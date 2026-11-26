class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        mat = new int[r][c];

        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                mat[i][j] = matrix[i][j];
                if(i>0) mat[i][j] += mat[i-1][j];
                if(j>0) mat[i][j] += mat[i][j-1];
                if(i>0 && j>0) mat[i][j] -= mat[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum1 = mat[row2][col2];
        int sum2 = 0;
        if(col1>0) sum2 = mat[row2][col1-1];
        int sum3 = 0;
        if(row1>0) sum3 = mat[row1-1][col2];
        int sum4 = 0;
        if(row1>0 && row2>0) sum4 = mat[row1-1][col1-1];

        return sum1 - sum2 - sum3 + sum4;
    }
}

// class NumMatrix {
//     int[][] mat;
//     public NumMatrix(int[][] matrix) {
//         int r = matrix.length;
//         int c = matrix[0].length;
//         mat = new int[r][c];

//         for(int i=0 ; i<r ; i++){
//             for(int j=0 ; j<c ; j++){
//                 mat[i][j] = matrix[i][j];
//             }
//         }
//     }
    
//     public int sumRegion(int row1, int col1, int row2, int col2) {
//         int result = 0;
//         for(int i=row1 ; i<=row2 ; i++){
//             for(int j=col1 ; j<=col2 ; j++){
//                 result += mat[i][j];
//             }
//         }
//         return result;
//     }
// }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */