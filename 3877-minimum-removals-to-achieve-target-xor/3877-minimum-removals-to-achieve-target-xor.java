class Solution {
    public int minRemovals(int[] nums, int target) {
       int n = nums.length;
        int totalXor = 0;
        for(int i=0; i<n; i++) totalXor ^=nums[i];
        if(totalXor == target) return 0;
        int required = totalXor^target;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
       for(int num : nums){
           Map<Integer, Integer> next = new HashMap<>(map);
           for(Map.Entry<Integer,Integer>key: map.entrySet()){
               int xor = key.getKey()^num;
               int count = key.getValue() + 1;
              if(!next.containsKey(xor)) next.put(xor,count);
               else next.put(xor, Math.min(next.get(xor),count));
           }
           map = next;
       }
        if(!map.containsKey(required)) return -1;
        return map.get(required);
    }
}