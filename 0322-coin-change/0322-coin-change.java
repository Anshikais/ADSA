class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(coins,amount,n-1,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans; 
    }
    public int solve(int[]coins, int amount,int n,int dp[][]){
    if(amount==0) return 0;
     if(n<0) return Integer.MAX_VALUE;
       if(dp[n][amount]!=-1)return dp[n][amount];
        int include = Integer.MAX_VALUE;
      if(coins[n]<=amount){
         include=solve(coins, amount-coins[n],n,dp);
         if(include!=Integer.MAX_VALUE){
            include+=1;
         }
      }
         int exclude = solve(coins, amount, n-1,dp);    
         return dp[n][amount]=Math.min(include,exclude);

    }
}