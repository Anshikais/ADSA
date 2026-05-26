class BrowserHistory {
   Stack<String> backward;
    Stack<String> forwards;
    String current;
    public BrowserHistory(String homepage) {
      backward = new Stack<>();
        forwards = new Stack<>();
        current = homepage;
    }
    
    public void visit(String url) {
        backward.push(current);
        current = url;
        forwards.clear();
    }
    
    public String back(int steps) {
        while(steps>0 && !backward.isEmpty()){
             forwards.push(current);
             current = backward.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        while(steps>0 && !forwards.isEmpty()){
            backward.push(current);
            current = forwards.pop();
            steps--;
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */