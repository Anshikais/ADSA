class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
          if(set.contains(n)){
            return false;
          } 
          set.add(n);
          n = number(n); 
        }
        return true;
    }
    public int number(int n){
        int val = 0;
        while(n>0){
            int digit = n%10;
            val +=digit*digit;
           n= n/10;
        }
        return val;
    }
}