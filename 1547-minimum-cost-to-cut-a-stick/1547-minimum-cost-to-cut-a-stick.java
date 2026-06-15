class Solution {
    public int minCost(int n, int[] cuts) {
     List<Integer> ans = new ArrayList<>();
     ans.add(0);
     for(int cut:cuts){
        ans.add(cut);
     }   
     ans.add(n);
     Collections.sort(ans);
     int m = ans.size();
    int[][] dp = new int[m][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(1, m - 2, ans, dp);
    }
   public int solve(int i,int j, List<Integer> cut,int[][]dp){
    if(i>j) return 0;
    if(dp[i][j]!=-1) return dp[i][j];
    int min = Integer.MAX_VALUE;
    for(int k=i; k<=j; k++){
    int cost = cut.get(j+1)-cut.get(i-1)+solve(i,k-1,cut,dp)+solve(k+1,j,cut,dp);
    min = Math.min(min,cost);
    }
    return dp[i][j] = min;
   }
}