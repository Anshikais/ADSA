class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for(int i=0; i<weights.length; i++){
          start = Math.max(start,weights[i]);
            end +=weights[i];
        }
          while(start<=end){
            int mid = start+(end-start)/2;
           if(ship(weights,mid)<=days){
            end = mid -1;
           }else start = mid +1;
        }
         return start;
    }
    public int ship(int[] weights,int mid){
        int days = 1;
        int count = 0;
        for(int i =0; i<weights.length; i++){
            if(count+weights[i]<=mid){
                count +=weights[i];
            }else{
                days++;
                count = weights[i];
            }
        }
        return days;
    }
}