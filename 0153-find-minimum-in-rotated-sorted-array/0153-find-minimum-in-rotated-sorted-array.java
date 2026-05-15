class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];
            for(int j=0; j<n; j++){
               min =  Math.min(min, nums[j]);
            
        }
        return min;
    }
}