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
    int[] rowDir = {1,-1,0,0};
    int[] colDir = {0,0,1,-1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        if(n==1 && m==1) return 0;
        int[][] ans = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               ans[i][j] =Integer.MAX_VALUE;  
            }
        }
       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist - b.dist);
       pq.add(new Pair(0,0,0));
       ans[0][0] = 0; 
       while(!pq.isEmpty()){
        Pair curr = pq.poll();
        if (curr.row == n - 1 && curr.col == m - 1) return curr.dist;
        for(int i=0; i<4; i++){
            int nx =curr.row + rowDir[i];
            int ny = curr.col + colDir[i];
        if(nx>=0 && nx<n && ny>=0 && ny<m){
            int minEffort = Math.max(curr.dist , Math.abs(heights[curr.row][curr.col] - heights[nx][ny]));
            if(minEffort <ans[nx][ny]){
                ans[nx][ny]=minEffort;
                pq.add(new Pair(nx,ny,minEffort));
            }
         }
        }
       }
       return 0;
    }
}