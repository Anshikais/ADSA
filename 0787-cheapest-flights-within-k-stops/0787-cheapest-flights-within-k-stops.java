class Solution {
    class Pair{
        int node;
        int cost;
        int stop;
        Pair(int node, int cost,int stop){
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            int v = flights[i][0];
            int u = flights[i][1];
            int w = flights[i][2];
            adj.get(v).add(new Pair(u,w,0));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        int[][] ans = new int[n][k+2];
        pq.add(new Pair(src,0,0));
          for(int i=0; i<n; i++){
              Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        ans[src][0] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
             if(curr.stop > k+1) continue;
           if(curr.node==dst) return curr.cost;
            for(int i=0; i<adj.get(curr.node).size(); i++){
                Pair neigh = adj.get(curr.node).get(i);
                int next = neigh.node;
                int newCost = curr.cost + neigh.cost;
                 int newStop = curr.stop + 1;
            if (newStop <= k + 1 && newCost < ans[next][newStop]) {
                   ans[next][newStop] = newCost;
                  pq.add(new Pair(next, newCost, newStop));
              }
            }
        }  
        return -1;
    }
}