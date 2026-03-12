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
         public boolean similar(String a, String b){
            int val = 0;
            for(int i=0; i<a.length();i++){
                if(a.charAt(i)!=b.charAt(i)){
                    val++;
                    if(val>2) return false;
                }
            }
              return val== 0 || val==2;
         }
    public int numSimilarGroups(String[] strs) {
        DSU obj = new DSU(strs.length);
        for(int i=0; i<strs.length; i++){
            for(int j=i+1; j<strs.length; j++){
               if(similar(strs[i],strs[j])){
                 obj.union(i,j);
               }
            }
        }
        int groups = 0;
        for(int i=0; i<strs.length; i++){
          if(obj.find(i)==i) groups++;
        }
        return groups;
    }
}