class Solution {
    public int longestStrChain(String[] words) {
      int n = words.length;
      int[][] dp = new int[n][n+1];
      Arrays.sort(words,(a,b) ->a.length()-b.length());
       for(int i=0; i<n; i++){
        Arrays.fill(dp[i],-1);
       }
       return solve(words,0,-1,dp);
    }
     public int solve(String[]words, int i, int prev, int[][]dp){
        if(i == words.length)  return 0;
        if(dp[i][prev + 1] != -1)  return dp[i][prev + 1];
        int notTake = solve(words, i + 1, prev, dp);
        int take = 0;
        if(prev == -1 || isPredecessor(words[prev], words[i])) {
            take = 1 +  solve(words, i + 1, i, dp);
        }
        return dp[i][prev+1] = Math.max(take,notTake);
}
 public boolean isPredecessor(String s1, String s2) {
        if(s2.length() != s1.length() + 1)
            return false;
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }else {
                j++;
            }
        }
        return i == s1.length();
 }
}