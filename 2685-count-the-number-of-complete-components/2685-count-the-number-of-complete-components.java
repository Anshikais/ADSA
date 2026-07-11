class Solution {
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> comp){
        visited[node]=true;
        comp.add(node);
        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                dfs(neigh,adj,visited,comp);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                List<Integer> comp = new ArrayList<>();
                dfs(i,adj,visited,comp);
                int size = comp.size();
                boolean complete = true;
                for(int node:comp){
                    if(adj.get(node).size()!=comp.size()-1){
                        complete = false;
                        break;
                    }
                }
                if(complete) ans++;
            }
        }
        return ans;
    }
}