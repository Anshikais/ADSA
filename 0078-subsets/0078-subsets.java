class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> set = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), set);
        return set;
    }
    public void solve(int i, int[]nums,List<Integer>ans,List<List<Integer>>set){
        if(i==nums.length){
            set.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
         solve(i+1, nums, ans, set);
        ans.remove(ans.size()-1);
        solve(i+1, nums, ans, set);
    }
}