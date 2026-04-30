class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[n][target + 1];
        return solve(nums,0,target,dp);
    }
    public Boolean solve(int[]nums, int i, int target, Boolean[][]dp){
        if(target==0) return true;
        if(i >= nums.length) return false;
        if(dp[i][target]!=null) return dp[i][target];
        boolean take = false;
        if(nums[i]<=target){
            take = solve(nums, i+1, target-nums[i], dp);
        }
        boolean skip = solve(nums,i+1,target,dp);
        return dp[i][target] = take || skip;
    }
}