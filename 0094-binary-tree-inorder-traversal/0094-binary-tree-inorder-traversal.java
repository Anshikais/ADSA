class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer>res = new ArrayList<>();
       inorder(root,res);
       return res;
    }
    private void inorder(TreeNode node, List<Integer>res){
        if(node==null) return;
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }
}