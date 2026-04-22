class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for(String s : queries){
           for(String l : dictionary){
            int diff = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=l.charAt(i)) diff++;
                if(diff>2) break;
            }
            if(diff<=2){
                list.add(s);
                break;
            }
           }
        }
        return list;
    }
}