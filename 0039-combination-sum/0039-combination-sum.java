class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(),res);
        return res;
    }
    public void solve(int i,int[] candidates, int target, List<Integer>ans,List<List<Integer>> res){
            if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
         if(i==candidates.length) return;
        if(candidates[i]<=target){
            ans.add(candidates[i]);
            solve(i,candidates,target-candidates[i],ans,res);
            ans.remove(ans.size()-1);
        }
         solve(i+1,candidates,target,ans,res);
    }
}