class Solution {
    class Pair{
        int row;
         int col;
         int dist;
         Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
         }
    }
    int[] rowDir = {0,0,1,-1};
    int[] colDir = {1,-1,0,0};
    public boolean isValid(int row, int col, int n, int m){
        return row>=0 && row<n && col>=0 && col<m;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] isvisited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
         q.add(new Pair(entrance[0], entrance[1], 0));
        isvisited[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if((curr.row==0 || curr.col==0 || curr.row==n-1 || curr.col==m-1)
            &&!(curr.row==entrance[0] && curr.col==entrance[1])){
                return curr.dist;
            }
            for(int i=0; i<4; i++){
                int nr = curr.row + rowDir[i];
                int nc = curr.col + colDir[i];
                if(isValid(nr,nc,n,m) && maze[nr][nc]=='.' && !isvisited[nr][nc]){
                    isvisited[nr][nc] = true;
                    q.add(new Pair(nr,nc, curr.dist+1));
                }
            }
        }
        return -1;
    }
}