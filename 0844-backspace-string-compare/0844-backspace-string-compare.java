class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> str = new Stack<>();
        int n = s.length();
        int m = t.length();
       for(int i=0; i<n; i++){
        char ch = s.charAt(i);
        if(ch !='#'){
            st.push(ch);
        }else{
            if(!st.isEmpty()) {
                 st.pop();
                }
        }
       }
       for(int j=0; j<m; j++){
         char ch = t.charAt(j);
         if(ch!='#'){
            str.push(ch);
         }else{
            if(!str.isEmpty()){
            str.pop();
         }
       }
}
 return st.equals(str); 
    }
}