class Solution {
    public int cherryPickup(int[][] grid) {
         int n = grid.length;
        Integer[][][][] dp = new Integer[n][n][n][n];
           return Math.max(0, solve(0,0,0,0,grid,dp));
    }
    public int solve(int r,int c, int r1, int c1, int[][]grid,Integer[][][][] dp){
         int n = grid.length;
        if(r>=n || c>=n || r1>=n || c1>=n) return Integer.MIN_VALUE;
        if(grid[r][c]==-1 || grid[r1][c1]==-1) return Integer.MIN_VALUE;
        if(r==n-1 && c==n-1 && r1==n-1 && c1==n-1) return grid[r][c];
        if(dp[r][c][r1][c1] != null) return dp[r][c][r1][c1];
        int cherry = grid[r][c];//person a
        if(r!=r1 || c!=c1) cherry +=grid[r1][c1];
        int a = solve(r+1,c,r1+1,c1,grid,dp);
        int b = solve(r,c+1,r1,c1+1,grid,dp);
        int c2 = solve(r+1,c,r1,c1+1,grid,dp);
        int d = solve(r,c+1,r1+1,c1,grid,dp);
        int max = Math.max(Math.max(a,b), Math.max(c2,d));
        return dp[r][c][r1][c1] = cherry + max;
    }
}