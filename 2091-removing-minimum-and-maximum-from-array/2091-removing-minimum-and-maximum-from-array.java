class Solution {
    public int minimumDeletions(int[] nums) {
      int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
      int minIndex = -1;
       int maxIndex = -1;
       for(int i=0; i<nums.length; i++){
        if(nums[i]>max){
            max = nums[i];
            maxIndex = i;
        }
        if(nums[i]<min){
            min = nums[i];
            minIndex = i;
        }
       }
        int left = Math.min(minIndex,maxIndex);
        int right = Math.max(maxIndex, minIndex);
        int option1 = right + 1;// remove all from left 5+1 = 6
      int option2 = nums.length - left; // remove from last index to 1
     int option3 = (left + 1) + (nums.length - right);// remove 1 from right 1 from left
     return Math.min(option1, Math.min(option2, option3));
    }
}