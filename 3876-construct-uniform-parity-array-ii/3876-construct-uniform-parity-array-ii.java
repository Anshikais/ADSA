class Solution {
    public boolean uniformArray(int[] nums1) {
       int minimum = nums1[0];
       int odd = 0;
       for(int x:nums1){
        minimum = Math.min(minimum,x);
        odd |= x&1;
       }
       return (minimum & 1) == odd;
    }
}