class NumArray {
      int[]tree;
      int n;
    public NumArray(int[] nums) {
       n = nums.length;
      tree = new int[4*n];
       build(nums,0,0,n-1);
       
    }
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
     private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        build(nums, 2 * node + 1, start, mid);
        build(nums, 2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    public int query(int node, int start,int end, int l, int r){
        if(end<l || start>r) return 0;
        if(start>=l && end<=r) return tree[node];
        int mid = (start+end)/2;
        int left = query(2*node+1,start,mid,l,r);
        int right = query(2*node+2,mid+1, end, l ,r);
        return left+right;
    }
}
