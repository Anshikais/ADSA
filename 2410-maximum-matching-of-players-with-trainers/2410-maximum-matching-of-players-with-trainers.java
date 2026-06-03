class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int l=0, r=0, count=0;
        while(l<n && r<m){
            if(players[l]<=trainers[r]){
                count++;
                l++;
                r++;
            }else{
                r++;
            }
        }
        return count;
    }
}