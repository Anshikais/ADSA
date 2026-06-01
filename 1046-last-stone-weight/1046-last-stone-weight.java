class Solution {
    public int lastStoneWeight(int[] stones) {
      int n = stones.length;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
    for(int i=0; i<n; i++){
        pq.add(stones[i]);
    } 
    while(pq.size()>1){
      pq.add(pq.poll()-pq.poll()); 
    } 
    return pq.poll();
    }
}