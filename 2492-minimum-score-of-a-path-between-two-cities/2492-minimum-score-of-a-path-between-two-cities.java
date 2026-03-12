class Solution {
    class DSU{
        int[] parent;
        int[] rank;
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
                parent[pb] = pa;
            }else{
                parent[pa]=pb;
                rank[pb]++;
            }
         }
    }
    public int minScore(int n, int[][] roads) {
        DSU obj = new DSU(n+1);
       int minScore = Integer.MAX_VALUE;
        for(int i=0; i<roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
           obj.union(u,v);
        }
         int parent = obj.find(1);
         for(int i=0; i<roads.length; i++){
            int u = roads[i][0];
            int d = roads[i][2];
            if(obj.find(u)==parent){
                minScore = Math.min(minScore,d);
            }
         }
        return minScore;
    }
}