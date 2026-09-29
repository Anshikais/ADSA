class Solution {
    public int maxDepth(String s) {
        int ans =0;
        int depth = 0;
        for(char ch : s.toCharArray()){
            depth += ch=='(' ? 1: ch==')' ?-1 :0;
            ans = Math.max(depth,ans);
        }
        return ans;
    }
}