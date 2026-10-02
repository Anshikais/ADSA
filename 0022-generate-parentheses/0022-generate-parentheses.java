class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack("", 0, 0, n, ans);
        return ans;
    }
    public void backtrack(String s, int i, int j, int n,List<String> ans){
          if(s.length()==2*n){
            ans.add(s);
            return; 
          }
          if(i<n){
            backtrack(s+"(",i+1,j,n,ans);
          }
          if(j<i){
            backtrack(s+")",i,j+1,n,ans);
          }
    }
}