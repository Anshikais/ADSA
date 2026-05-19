class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
         int[][] team = new int[n][2];
        for(int i = 0; i < n; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }
        Arrays.sort(team, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++){
              Arrays.fill(dp[i],-1);
        }
        return solve(team,0,-1,dp);
    }
      public int solve(int[][] team, int i, int prev, int[][] dp){
         if(i==team.length) return 0;
         if(dp[i][prev+1]!=-1) return dp[i][prev+1];
         int skip = solve(team,i+1, prev,dp);
         int take = 0;
         if(prev==-1 || team[i][1]>=team[prev][1]){
            take = team[i][1] + solve(team,i+1,i,dp); 
         }
         return dp[i][prev + 1] = Math.max(take, skip);
      }
}