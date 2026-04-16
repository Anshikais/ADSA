class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea =0;
        for(int i=0; i<=n; i++){
            int currheight;
            if(i==n){
                currheight=0;
            }else{
                currheight = heights[i];
            }
            while(!st.isEmpty() && currheight<heights[st.peek()]){
                int height = heights[st.pop()];
                int right = i;
                int left;
                if(st.isEmpty()){
                    left = -1;
                }else{
                    left = st.peek();
                }
                int width = right-left-1;
                int area = height*width;
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }
        return maxArea;
    }
}