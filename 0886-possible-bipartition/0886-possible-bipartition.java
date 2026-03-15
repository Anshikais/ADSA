class Solution {
     class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x]==x) return x;
            return parent[x] = find(parent[x]);
        }
        public void union(int a,int b){
            int pa = find(a);
            int pb = find(b);
            if(pa==pb) return;
            if(rank[pa]<rank[pb]){
                parent[pa] = pb;
            }else if(rank[pb]<rank[pa]){
                parent[pb]=pa;
            }else{
                parent[pa] = pb;
                rank[pb]++;
            }
         }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                 for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
          }
          for(int i=0; i<dislikes.length; i++){
             int u = dislikes[i][0];
             int v = dislikes[i][1];
               adj.get(u).add(v);
              adj.get(v).add(u);
          }
          DSU obj = new DSU(n+1);
          for(int i=1; i<=n; i++){
              if(adj.get(i).size()==0) continue;
            int first = adj.get(i).get(0);
            for(int j=0; j<adj.get(i).size(); j++){
                int neigh = adj.get(i).get(j);
                if(obj.find(i)==obj.find(neigh)) return false;
                obj.union(first,neigh);
            }
          }
          return true;
    }
}