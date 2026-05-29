class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int num :nums){
            int sum = 0;
           while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
          min = Math.min(min,sum);
        }
        return min;
    }
}