class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        for(int i=0 ; i<n ; i++){
            for(int j=i+1 ; j<n ; j++){
                int first = Math.max(triplets[i][0], triplets[j][0]);
                int second = Math.max(triplets[i][1], triplets[j][1]);
                int third = Math.max(triplets[i][2], triplets[j][2]);

                if(first==target[0] && second==target[1] && third==target[2]){
                    return true;
                }
            }
        }
        return false;
    }
}
