class Solution {
    public int[] countBits(int n) {
        int dp[] = new int[n+1];
        int ans = 1;
        for(int i=1; i<=n; i++){
            if(ans*2==i){
                ans = i;
            }
            dp[i] = dp[i-ans] + 1;
        } 
        return dp;
    }
}