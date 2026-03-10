class Solution {
    class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parent[i]=i;
            }
        }
            public int find(int x){
                if(parent[x]==x) return x;
                return parent[x] = find(parent[x]);
            }
        public void union(int a,int b){
            int pa = find(a);
            int pb = find(b);
            if(pb!=pa){
             if(rank[pa]>rank[pb]){
                parent[pb] = pa;
             }else if(rank[pb]>rank[pa]){
                parent[pa] = pb;
             } else{
                 parent[pb] = pa;
                 rank[pa]++;
             }
            }
        }   
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        DSU obj = new DSU(n);
        for(int i=0; i<connections.length; i++){
                obj.union(connections[i][0],connections[i][1]);
        }
        int time = 0;
        for(int i=0; i<n; i++){
            if(obj.find(i)==i){
                time++;
            }
        }
        return time-1;
    }
}