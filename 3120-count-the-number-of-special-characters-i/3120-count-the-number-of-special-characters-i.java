class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        HashSet<Character> set = new HashSet<>();
      HashSet<Character> upper = new HashSet<>();
        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
        if(Character.isLowerCase(ch)) {
            set.add(ch);
        }else{
            upper.add(ch);
         }
        }
    int count = 0;
    for(char ch : set){
        if(upper.contains(Character.toUpperCase(ch))){
            count++;
        }
    }
        return count;
    }
}