class Solution {
    public int minimizedMaximum(int n, int[] quantites) {
        int start = 1;
        int end = 0;
        for(int i=0; i<quantites.length; i++){
            end = Math.max(end,quantites[i]);
            
        }
        int ans = 0;
        while(start<=end){
         int mid = (start+end)/2;
         if(split(n,quantites,mid)){
          ans = mid;
          end = mid-1;
         }else{
            start = mid+1;
         }
        }
        return ans;
    }
    public boolean split(int n, int[]quantites,int mid){
        int store = 0;
        for(int i=0; i<quantites.length; i++){
            store +=(quantites[i]+mid-1)/mid;
        }
        return store<=n;
    }
}