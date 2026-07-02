class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            int low = 0;
            int high = list.size()-1;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(list.get(mid)>=num){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
                if(low==list.size()){
                    list.add(num);
                }else{
                    list.set(low,num);
                }
        }
        return list.size();
    }
}