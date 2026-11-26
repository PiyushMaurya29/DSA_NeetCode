class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];

        for(int i=0 ; i<n ; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));

        double[] time = new double[n];
        for(int i=0 ; i<n ; i++){
            double currTime = (target-pair[i][0]) / (double)(pair[i][1]);
            time[i] = currTime;
        }
        Stack<Double> stack = new Stack<>();
        for(double t : time){
            if(stack.isEmpty()) stack.push(t);
            else{
                if(!stack.isEmpty() && stack.peek()<=t) continue;
                else stack.push(t);
            }
        }
        return stack.size();
    }
}



// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n = position.length;

//         List<double[]> pairList = new ArrayList<>(); // Position and TimeTaken
//         for(int i=0 ; i<n ; i++){
//             double timeTaken = (double)(target-position[i]) / speed[i];
//             pairList.add(new double[]{position[i], timeTaken});
//         }

//         Collections.sort(pairList, (a,b) -> Double.compare(a[0], b[0]));
//         Stack<double[]> stack = new Stack<>();

//         for(int i=0 ; i<n ; i++){
//             // If the timeTaken by the previous car is less than the current car it will cause a fleet of car
//             while(!stack.isEmpty() && stack.peek()[1]<=pairList.get(i)[1]){
//                 stack.pop();
//             }
//             stack.push(pairList.get(i));
//         }
//         return stack.size();
//     }
// }
