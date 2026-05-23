class Solution {
    public boolean check(int[] nums) {
       int n = nums.length;
       int val = 0;
       for(int i=0; i<n; i++){
        if(nums[i]>nums[(i+1)%n]){
            val++;
        }
       }
      return val<=1;
    }
}