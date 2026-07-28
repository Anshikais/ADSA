class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int count = 0;
        int max = 0;
        int l = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            while(set.contains(nums[i])){
                set.remove(nums[l]);
                count -=nums[l];
                l++;
            }
            set.add(nums[i]);
            count +=nums[i];
            max = Math.max(max,count);
        }
        return max;
    }
}