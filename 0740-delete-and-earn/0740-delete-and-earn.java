class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
          int max = 0;
     for(int num :nums) max = Math.max(num,max);
        int[] sum = new int[max + 1];
        for(int num : nums){
            sum[num] += num;
        }
     int[] dp = new int[max+1];
       Arrays.fill(dp,-1);
      return solve(sum,dp, max);
    }
   public int solve(int[]nums, int[]dp, int i){
     if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);
      if(dp[i]!= -1) return dp[i];
      int take = nums[i] + solve(nums, dp, i-2);
        int skip = solve(nums, dp, i-1);
        return dp[i] = Math.max(take, skip);
   }
}