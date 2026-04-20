class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int m = nums2.length;
        int max = 0;
        int i =0;
        int j = 0;
        while(i<n && j<m){
        if(i<=j && nums1[i]<=nums2[j]){
            max = Math.max(max,j-i);
            j++;
        }else{
           if( i<=j && nums1[i]>=nums2[j]){
            i++;
           }else if(i>j){
            j++;
           }
        }
    }
    return max;
    }
}