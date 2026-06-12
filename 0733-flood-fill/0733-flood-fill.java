 class Solution {
     class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[] rowDir = {1,-1,0,0};
    int[] colDir = {0,0,1,-1};
    public boolean isValid(int row,int col, int n, int m){
       return  row>=0 && row<n && col>=0 && col<m;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original==color) return image;
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        boolean[][] visited = new boolean[n][m];
        visited[sr][sc]=true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0; i<4; i++){
              int nr = curr.row + rowDir[i];
              int nc = curr.col + colDir[i];
              image[curr.row][curr.col] = color;
              if(isValid(nr,nc,n,m) && image[nr][nc]==original && !visited[nr][nc]){
                visited[nr][nc] = true;
                q.add(new Pair(nr,nc));
              }
            }
        }
        return image;
    }
}