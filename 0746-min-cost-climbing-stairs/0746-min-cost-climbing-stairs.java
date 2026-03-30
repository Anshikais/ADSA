class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
         int dp[] = new int[n+1];
         dp[0] = cost[0];
         dp[1] = cost[1];
        for(int i=2; i<n; i++){
            int first = dp[i-1];
            int second = dp[i-2];
         dp[i] = cost[i] + Math.min(first, second);
        } 
         int first = dp[n-1];
         int second = dp[n-2];
        return Math.min(first,second);
    }
}