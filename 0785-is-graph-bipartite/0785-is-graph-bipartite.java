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
    public boolean isBipartite(int[][] graph) {
        DSU obj = new DSU(graph.length);
      for( int i=0; i<graph.length; i++){
        for(int j=0; j<graph[i].length; j++){
            if(obj.find(i)==obj.find(graph[i][j]))
                return false;
                obj.union(graph[i][0],graph[i][j]);
            
        }
      }
      return true;
    }
}