class Solution {
    public int jump(int[] nums) {
        int ans=0;
        int end=0;
        int fast=0;
        for(int i=0; i<nums.length-1; i++){
            fast = Math.max(fast , i+nums[i]);
            if(fast>=nums.length-1){
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