class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length()==0) return 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int i=0;
        int j = s.length();
        // skip whitespace
        while(i<j && s.charAt(i)==' '){
            i++;
        }
        // if reach to end
        if(i==j)return 0;
        // this is for sign case
          int sign = 1;
          if(s.charAt(i)=='+'){
            i++;
          }else if (s.charAt(i)=='-'){
            sign = -1;
            i++;
          }
      // for digits
      long res = 0;
      while(i<j && Character.isDigit(s.charAt(i))){
        int digit = s.charAt(i)-'0';
         res = res*10+digit;
        if(sign*res<=min) return min;
        if(sign*res>=max) return max;
        i++;
      }
    return (int) (res*sign);
    }
}