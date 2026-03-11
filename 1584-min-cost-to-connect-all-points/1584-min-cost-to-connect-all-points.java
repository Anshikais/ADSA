class Solution {
    class Pair{
        int row;
        int col;
        int wt;
        Pair(int row,int col,int wt){
            this.row = row;
            this.col = col;
            this.wt = wt;
        }
    }
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
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Pair> adj = new ArrayList<>();
        int minCost = 0;
        int n = points.length;
     for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
           minCost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            adj.add(new Pair(i,j,minCost)); 
        }
     }
      Collections.sort(adj,(a,b)->a.wt-b.wt);
      DSU obj = new DSU(n);
      int cost =0;
      for(int i=0; i<adj.size(); i++){
        Pair p = adj.get(i);
        int u = p.row;
        int v = p.col;
        int wt = p.wt;
        if(obj.find(u)!=obj.find(v)){
            obj.union(u,v);
            cost += wt;
        }
      }
      return cost;
    }
}