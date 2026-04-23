class Solution {
      class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    int[] rowDir = {1,-1,0,0};
    int[] colDir = {0,0,1,-1};
    public boolean isValid(int row,int col, int n, int m){
        return row>=0 && row<n && col>=0 && col<m;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }
      int min = 0;
      while(!q.isEmpty() && fresh>0){
        int size = q.size();
        while(size>0){
            size--;
            Pair curr = q.poll();
            for(int i=0; i<4; i++){
                int nr = curr.row + rowDir[i];
                int nc = curr.col + colDir[i];
                if(isValid(nr,nc,n,m) && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                   q.add(new Pair(nr,nc));
                }
            }
        }
        min++;
      } 
       if(fresh!=0) return -1;
      return min; 
    }
}