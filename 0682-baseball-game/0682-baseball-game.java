class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("+")){
                st.push(st.peek()+st.get(st.size()-2));
             } else if (operations[i].equals("D")) {
                st.push(2 * st.peek());
            } else if (operations[i].equals("C")) {
                st.pop();
             } else {
                int a = Integer.parseInt(operations[i]);
                st.push(a);
            }
        }
         int sum = 0;
        for (int j = 0; j<st.size(); j++) {
            sum += st.get(j);
        }
        return sum; 
    }
}