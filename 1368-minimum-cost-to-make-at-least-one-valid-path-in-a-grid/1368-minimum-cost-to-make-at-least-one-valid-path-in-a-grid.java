class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col,int dist){
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
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist-b.dist);
       boolean[][] visited = new boolean[n][m];
        pq.add(new Pair(0,0,0));
       while(!pq.isEmpty()){
        Pair curr = pq.poll();
      if(visited[curr.row][curr.col]) continue;
       visited[curr.row][curr.col] = true;
        if(curr.row==n-1 && curr.col==m-1) return curr.dist;
        for(int i=0; i<4; i++){
            int nr = curr.row + rowDir[i];
            int nc = curr.col + colDir[i];
             if(!isValid(nr,nc,n,m)) continue;
            int cost = curr.dist;
           if(grid[curr.row][curr.col]!=i+1) cost++;
           pq.add(new Pair(nr,nc,cost));
        }
       }
       return -1;
    }
}