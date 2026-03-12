class Solution {
    class Pair{
        int v,u,wt;
        Pair(int v,int u,int wt){
            this.v = v;
            this.u = u;
            this.wt = wt;
        }
    }
     class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i=0; i<=n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x]==x) return x;
            return parent[x] = find(parent[x]);
        }
        public boolean union(int a,int b){
            int pa = find(a);
            int pb = find(b);
            if(pa==pb) return false;
            if(rank[pa]<rank[pb]){
                parent[pa] = pb;
            }else if(rank[pb]<rank[pa]){
                parent[pb]=pa;
            }else{
                parent[pb] = pa;
                rank[pa]++;
            }
             return true;
         }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int removed = 0;
        for(int i=0; i<edges.length; i++){
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            if(type == 3){
                boolean a = alice.union(u,v);
                boolean b = bob.union(u,v);
                if(!a && !b){
                    removed++;
                }
            }
        }
            for(int i=0;i<edges.length;i++){
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            if(type == 1){
                if(!alice.union(u,v)){
                    removed++;
                }
            }
        } 
        for(int i=0;i<edges.length;i++){
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            if(type == 2){
                if(!bob.union(u,v)){
                    removed++;
                }
            }
        }
         int compA = 0;
        int compB = 0;

        for(int i=1;i<=n;i++){
            if(alice.find(i) == i) compA++;
            if(bob.find(i) == i) compB++;
        }

        if(compA > 1 || compB > 1) return -1;

        return removed;
    }
}

