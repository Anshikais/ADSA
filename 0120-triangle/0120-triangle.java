class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return solve(0,0,triangle,dp);
    }
    public int solve( int r, int c,List<List<Integer>> triangle,Integer[][]dp){
         int n = triangle.size();
        if(r==n-1) return triangle.get(r).get(c);
     if(dp[r][c] != null) return dp[r][c];
        int left = solve(r+1, c, triangle,dp);
        int right = solve(r+1,c+1,triangle,dp);
        return dp[r][c] =triangle.get(r).get(c) +Math.min(left,right);
    }
}