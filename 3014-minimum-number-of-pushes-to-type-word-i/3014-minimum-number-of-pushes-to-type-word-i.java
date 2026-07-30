class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
         int ans = 0;
         for(int i=0; i<n; i++){
            ans +=(i/8) + 1;// jabtak value i ki less than hai 8 ke tabtak 1 add hoga uske baad jo value aayega wo 
         }
         return ans;
    }
}