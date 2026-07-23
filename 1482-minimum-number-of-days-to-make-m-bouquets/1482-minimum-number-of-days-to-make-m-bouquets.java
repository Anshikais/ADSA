class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long flower = 1L*m*k;// cause integer overflow 
        if(flower>bloomDay.length) return -1;
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int day : bloomDay){
             low = Math.min(low,day);
            high = Math.max(high,day);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            if(bloom(bloomDay,m,k,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
         return low;
    }
    public boolean bloom(int[]bloomDay,int m,int k, int day){
           int count = 0;
           int bouquet = 0;
           for(int i=0;i<bloomDay.length; i++){
            if(bloomDay[i]<=day){
                count++;
                if(count==k){
                    bouquet++;
                    count = 0;
                }
            }else{
                count = 0;
            }
           }
           return bouquet>=m;
    }
}