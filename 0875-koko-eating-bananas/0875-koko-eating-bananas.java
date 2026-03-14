class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
      for(int i=0; i<piles.length; i++){
        end = Math.max(end, piles[i]);
      } 
       int ans = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(isPossible(piles,h,mid)){
              ans = mid;
              end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[]piles,int hours,int mid){
        int time = 0;
        for(int i=0; i<piles.length; i++){
            time += Math.ceil((double)piles[i]/mid);
        }if(time<=hours) return true;
        return false;
    }
}