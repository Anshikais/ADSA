class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int [n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(text1,text2,0,0,dp);
    }
    public int solve(String text1,String text2,int i, int j, int[][]dp ){
        if(i == text1.length() || j == text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int take1 = solve(text1,text2,i+1,j,dp);
        int take2 = solve(text1,text2,i,j+1,dp);
        int take = 0;
        if(text1.charAt(i)==text2.charAt(j)){
           take = 1+solve(text1,text2,i+1,j+1,dp);
        }
         return dp[i][j] =Math.max(take, Math.max(take1,take2));
    }
}