class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
           Queue<Integer> q = new LinkedList<>();
           q.add(start);
           while(!q.isEmpty()){
            int curr = q.poll();
            if(curr<0 || curr>=n || visited[curr]) continue;
            if(arr[curr]==0) return true;
            visited[curr] = true;
            q.add(curr+arr[curr]);
            q.add(curr-arr[curr]);
           }
        return false;
    }
}