class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for(int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        int ans = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(split(nums,mid,k)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public boolean split(int[]nums, int mid, int k){
        int count = 1;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            if((sum+nums[i])>mid){
                count++;
                sum = nums[i];
            }else{
                sum +=nums[i];
            }
        }
        return count<=k;
    }
}