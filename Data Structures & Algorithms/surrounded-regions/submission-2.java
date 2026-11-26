class Solution {
    int r, c;

    int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void markVisitedDFS(int i, int j, boolean[][] visited, char[][] board){
        visited[i][j] = true;
        for(int[] d : directions){
            int adjRow = i + d[0];
            int adjCol = j + d[1];
            if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && board[adjRow][adjCol]=='O'){
                markVisitedDFS(adjRow, adjCol, visited, board);
            }
        }
    }
    public void markVisitedBFS(int i, int j, boolean[][] visited, char[][] board){
        // Queue<int[]> queue = new LinkedList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] d : directions){
                int adjRow = curr[0] + d[0];
                int adjCol = curr[1] + d[1];
                if(adjRow>=0 && adjRow<r && adjCol>=0 && adjCol<c && !visited[adjRow][adjCol] && board[adjRow][adjCol]=='O'){
                    queue.offer(new int[]{adjRow, adjCol});
                    visited[adjRow][adjCol] = true;
                }
            }
        }
    }
    public void solve(char[][] board) {
        r = board.length;
        c = board[0].length;

        boolean[][] visited = new boolean[r][c];

        for(int i=0 ; i<r ; i++){
            if(board[i][0] == 'O'){
                // markVisitedDFS(i, 0, visited, board);
                markVisitedBFS(i, 0, visited, board);
            }
            if(board[i][c-1] == 'O'){
                // markVisitedDFS(i, c-1, visited, board);
                markVisitedBFS(i, c-1, visited, board);
            }
        }

        for(int j=0 ; j<c ; j++){
            if(board[0][j] == 'O'){
                // markVisitedDFS(0, j, visited, board);
                markVisitedBFS(r-1, j, visited, board);
            }
            if(board[r-1][j] == 'O'){
                // markVisitedDFS(r-1, j, visited, board);
                markVisitedBFS(r-1, j, visited, board);
            }
        }

        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
