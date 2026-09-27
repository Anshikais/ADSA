class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = 0;
        int j = 0;
         for (int i = 0; i < houses.length; i++) {
            while (j + 1 < heaters.length &&
                   Math.abs(houses[i] - heaters[j + 1]) <=
                   Math.abs(houses[i] - heaters[j])) {
                j++;
            }
                int dis = Math.abs(houses[i]-heaters[j]);
                max = Math.max(max,dis);
            }
        return max;
    }
}