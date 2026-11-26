class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] i : intervals){
            if(list.isEmpty()){
                list.add(i);
            }            
            else{
                int n = list.size();
                if(list.get(n-1)[1] >= i[0]){
                    list.get(n-1)[1] = Math.max(list.get(n-1)[1], i[1]);
                }
                else{
                    list.add(i);
                }
            }
        }
        
        int n = list.size();
        int[][] result = new int[n][2];
        for(int i=0 ; i<n ; i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
