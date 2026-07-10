class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length;
        int m = capacity.length;
        Arrays.sort(capacity);
        int total = 0;
        int box = 0;
        int currentCapacity = 0;
       for(int i=0; i<n; i++){
         total += apple[i];
       }
       for(int i=m-1; i>=0; i--){
        currentCapacity += capacity[i];
            box++;
         if( currentCapacity>=total){
           return box;
         }
       } 
       return box;
    }
}