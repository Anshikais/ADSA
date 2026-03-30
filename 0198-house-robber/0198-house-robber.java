class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return robber(nums,n-1,dp);
    }
    public int robber(int[]nums, int i, int[]dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int first = nums[i] + robber(nums, i-2, dp);
        int second = robber(nums, i-1, dp);
        dp[i] = Math.max(first,second);
        return dp[i];
    }
}