class Solution {
    public int solve(int curr, int n, int dp[]) {
        if (curr == n) return 1;
        if (curr > n) return 0;
        if (dp[curr] != -1) return dp[curr];
        int first = solve(curr + 1, n, dp);
        int second = solve(curr + 2, n, dp);
        return dp[curr] = first + second;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, dp);
    }
}