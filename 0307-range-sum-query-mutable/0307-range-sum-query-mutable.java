class NumArray {
       int[]tree;
      int n;
    public NumArray(int[] nums) {
        n = nums.length;
      tree = new int[4*n];
       build(nums,0,0,n-1); 
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
    public void updateTree( int node , int start, int end, int index, int val){
        if(start==end){
            tree[node] = val;
            return;
        }
        int mid = (start+end)/2;
        if(index<=mid) updateTree(2*node+1, start, mid,index, val);
       else  updateTree(2*node+2, mid+1,end,index,val);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    public void update(int index, int val) {
        updateTree(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
      return  query(0,0,n-1,left,right);
    }
   public int query(int node,int start, int end, int l, int r){
    if(end<l || start>r) return 0;
    if(start>=l && end<=r) return tree[node];
    int mid = (start+end)/2;
    int left = query(2*node+1, start, mid, l, r);
    int right = query(2*node+2, mid+1, end, l, r);
    return left+right;
   }
}

