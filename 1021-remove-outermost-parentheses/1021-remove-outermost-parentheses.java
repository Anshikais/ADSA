class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth =0, start=0, end=0;
        while(end<s.length()){
            if(s.charAt(end)=='(') depth++;
           else depth--;
           if(depth==0){
            sb.append(s.substring(start+1,end));
            start = end+1;
           }
           end++;
        }
        return sb.toString();
    }
}