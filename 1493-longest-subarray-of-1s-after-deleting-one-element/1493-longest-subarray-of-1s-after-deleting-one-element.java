class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int count=0, maxCount = 0, j=0; 
       for(int i=0; i<n; i++){
        if(nums[i]==0){
            count++;
        }
        while(count>1){
            if(nums[j]==0){
                count--;
            }
            j++;
        }
        maxCount = Math.max(maxCount,i-j+1-1);
       } 
       return maxCount;
    }
}