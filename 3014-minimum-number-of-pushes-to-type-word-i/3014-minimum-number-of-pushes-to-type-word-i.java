class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            ans +=(i/8)+1;// jabtak i less than 8 hoga tabtak 1 add karega uske baad jo value hoga wo
        }
        return ans;
    }
}