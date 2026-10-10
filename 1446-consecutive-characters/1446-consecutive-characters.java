class Solution {
    public int maxPower(String s) {
       int ans = 1;
       int best = 1;
       for(int i=1; i<s.length(); i++){
        if(s.charAt(i)==s.charAt(i-1)){
            best++;
            ans = Math.max(best,ans);
            continue;
        }
        best = 1;
       }
       return ans;
    }
}