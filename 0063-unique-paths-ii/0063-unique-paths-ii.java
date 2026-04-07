class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        Integer[][] dp = new Integer[n][m];
        if(obstacleGrid[0][0]==1) return 0;
        return solve(0,0,n,m,obstacleGrid,dp);

    }
    public int solve(int r, int c, int n,int m ,int[][] obstacleGrid, Integer dp[][]){
         if(r>=n || c>=m) return 0;
         if(obstacleGrid[r][c]==1) return 0;
         if(r==n-1 && c==m-1) return 1;
         if(dp[r][c]!=null) return dp[r][c];
         int right = solve(r,c+1,n,m,obstacleGrid,dp);
         int left = solve(r+1,c,n,m,obstacleGrid,dp);
         return dp[r][c] = left+right;
    }
}