class Solution {
    public int maximumCandies(int[] candies, long k) {
        int start = 1;
        int end = 0;
        for(int i=0; i<candies.length; i++){
            end = Math.max(end,candies[i]);
        }
        int ans = 0;
        while(start<=end){
        int mid = (start+end)/2;
        long count = 0;
        for(int i=0; i<candies.length; i++){
            count += candies[i]/mid;
        }
        if(count>=k){
            ans = mid;
            start = mid + 1;
        }else{
             end = mid -1;
        }
        }
        return ans;
    }
}