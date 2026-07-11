class Solution {
    public int maxProduct(int[] nums) {
       int ans = Integer.MIN_VALUE;
       for(int i=0; i<nums.length; i++){
        ans = Math.max(ans,nums[i]);
       } 
       int currMax = 1;
       int currMin = 1;
       for(int n:nums){
        int val = currMax*n;
        currMax = Math.max(val,Math.max(currMin*n,n));
        currMin = Math.min(val,Math.min(currMin*n,n));
        ans = Math.max(ans,currMax);
       }
       return ans;
    }
}