class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
       int[][] dp = new int[n][amount+1];
       for(int i=0; i<n; i++){
        Arrays.fill(dp[i],-1);
       } 
       return solve(amount,coins,n-1,dp);
    }
    public int solve(int amount, int[]coins, int n, int[][]dp){
        if(amount==0) return 1;
        if(n<0) return 0;
        if(dp[n][amount]!=-1) return dp[n][amount];
        int skip = solve(amount,coins,n-1,dp);
        int take = 0;
        if(coins[n]<=amount){
            take = solve(amount-coins[n],coins,n,dp);
        }
        return dp[n][amount]= skip+take;
    }
}