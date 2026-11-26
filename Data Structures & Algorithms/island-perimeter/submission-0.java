class Solution {
    int r, c;
    public int getContribution(int i, int j, int[][] grid){
        int neighbour = 0;
        if(i-1>=0 && grid[i-1][j]==1) neighbour++;
        if(i+1<r && grid[i+1][j]==1) neighbour++;
        if(j-1>=0 && grid[i][j-1]==1) neighbour++;
        if(j+1<c && grid[i][j+1]==1) neighbour++;

        return (4-neighbour); 
    }
    public int islandPerimeter(int[][] grid) {
        r = grid.length;
        c = grid.length;

        int result = 0;
        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(grid[i][j] == 1){
                    result += getContribution(i, j, grid);
                }
            }
        }
        return result;
    }
}