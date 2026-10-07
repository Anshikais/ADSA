class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq);
        int unique = map.size();
        for(int i=0; i<freq.size(); i++){
            if(k>= freq.get(i)){
               k=k- freq.get(i);
               unique--;
            }
        }
        return unique;
    }
}