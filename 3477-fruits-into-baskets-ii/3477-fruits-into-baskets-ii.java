class Solution {
    int[] tree;
    int n;
  public void build(int[]nums,int node, int start, int end){
    if(start==end){
        tree[node]=nums[start];
        return;
    }
    int mid = (start+end)/2;
    build(nums,2*node+1, start, mid);
    build(nums, 2*node+2, mid+1, end);
    tree[node] = tree[2*node+1] + tree[2*node+2];
  }
  public void update (int node, int start, int end, int idx){
    if(start==end){
        tree[node]=0;
        return;
    }
    int mid = (start+end)/2;
    if(idx<=mid) update(2*node+1,start,mid,idx);
    else update(2*node+2,mid+1, end, idx);
    tree[node] = tree[2*node+1] + tree[2*node+2];
  }
  public int Query(int node,int start, int end, int target){
    if(tree[node]<target) return -1;
       if(start==end) return start;
        int mid = (start+end)/2;
        int left = Query(2*node+1, start, mid,target);
        if(left!=-1) return left;
        return Query(2*node+2, mid+1, end,target);    
  }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        tree = new int[4*n];
        build(baskets,0,0,n-1);
        int unplaced = 0;
        for(int fruit:fruits){
       int idx = Query(0,0,n-1,fruit);
       if(idx==-1){
        unplaced++;
       }else{
        update(0,0,n-1, idx);
       }
        }
        return unplaced;
    }
}