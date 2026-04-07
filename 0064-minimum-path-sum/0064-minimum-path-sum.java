class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer [][] dp = new Integer[n][m];
       return solve(0,0,n,m,grid,dp);
    }
    public int solve(int r,int c, int n, int m,int[][] grid, Integer dp[][]){
        if(r >= n || c >= m) return Integer.MAX_VALUE;
        if(r == n-1 && c == m-1) return grid[r][c];
        if(dp[r][c] != null) return dp[r][c];
        int left = solve(r,c+1,n,m,grid,dp);
        int right = solve(r+1, c, n,m,grid,dp);
        return dp[r][c] = grid[r][c]+Math.min(left,right);
    }
}