class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
          return solve(0,0,m,n,dp);
        
    }
    public int solve(int r, int c,int m, int n, Integer dp[][]){
        if(r >= m || c >= n) return 0;
        if(r==m-1 && c==n-1) return 1;
        if(dp[r][c]!=null) return dp[r][c];
        int right = solve(r,c+1,m,n,dp);
        int down = solve(r+1, c, m,n,dp);
        return dp[r][c] = right+down; 
    }
}