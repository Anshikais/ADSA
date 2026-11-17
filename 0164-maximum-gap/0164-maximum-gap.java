class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int diff = 0;
        for(int i=1; i<nums.length; i++){
              diff =nums[i]-nums[i-1];
              max = Math.max(max,diff);
            }
        return max;
    }
}