class Solution {
   public int solve(int[] cost,int n,int[]dp){
    if(dp[n]!=-1) return dp[n];
        if(n==0) return cost[0];
        if(n==1) return cost[1];
     return dp[n] = cost[n] + Math.min(solve(cost, n - 1, dp),solve(cost, n - 2, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
       int []dp = new int[n+1];
       Arrays.fill(dp,-1);
        return Math.min(solve(cost, n - 1, dp),  solve(cost, n - 2, dp) );
    } 
}