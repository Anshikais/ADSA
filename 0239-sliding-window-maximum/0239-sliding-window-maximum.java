class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int j = 0;
        int n = nums.length;
        int[] ans =new int[n-k+1];
        for(int i=0; i<n; i++){
        while(!dq.isEmpty() && nums[dq.getLast()]<nums[i]){
            dq.removeLast();
        } 
        dq.addLast(i);
        if(dq.getFirst()+k==i){
            dq.removeFirst();
        }
        if(i>=k-1){
            ans[j++] = nums[dq.getFirst()];
            }
        }
        return ans;
    }
}