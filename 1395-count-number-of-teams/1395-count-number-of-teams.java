class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int lessleft = 0, lessright =0;
            int grtleft = 0, grtright = 0;
            for(int j =0; j<i; j++){
                if(rating[j]<rating[i])lessleft++;
                else if(rating[j]>rating[i]) grtleft++;
            }
            for(int k=i+1; k<n; k++){
                if(rating[k]<rating[i]) lessright++;
                else if(rating[k]>rating[i]) grtright++;
            }
            count +=(lessleft*grtright) + (lessright*grtleft);
        }
        return count;
    }
}