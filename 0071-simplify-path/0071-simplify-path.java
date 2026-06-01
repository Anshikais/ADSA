class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");
         for(String part :parts){
        if(part.equals(".") || part.isEmpty()) continue;
        else if (part.equals("..")) {
        if(!st.isEmpty()){
            st.pop();
        }
        }else{
            st.push(part);
        }
    }
     if (st.isEmpty())  return "/";
        StringBuilder ans = new StringBuilder();
        for (String val : st) {
            ans.append("/").append(val);
        }
        return ans.toString();
         }
}