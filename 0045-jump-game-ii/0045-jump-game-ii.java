class Solution {
    public int jump(int[] nums) {
        int n = nums.length-1;
        int ans=0;
        int end=0;  
        int fast=0;
        for(int i=0; i<n; i++){
            fast = Math.max(fast , i+nums[i]);
            if(fast>=n){
                ans++;
                break;
            }
            if(i==end){
                ans++;
                end=fast;
            }
        }
        return ans;
    }
}