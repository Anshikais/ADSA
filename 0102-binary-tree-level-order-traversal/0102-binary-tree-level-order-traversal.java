class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       if(root==null)return ans;
       q.offer(root);
       while(!q.isEmpty()){
        List<Integer> res = new ArrayList<>();
        int n=q.size();
        for(int i=0; i<n; i++){
            TreeNode front = q.poll();
            res.add(front.val);
            if (front.left != null) q.offer(front.left);
            if (front.right != null) q.offer(front.right);
        }
        ans.add(res);
       }
       return ans;
    }
}