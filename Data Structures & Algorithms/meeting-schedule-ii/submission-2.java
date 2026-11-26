/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // The approach is to sort by the end time and put it in minHeap
        // And check if next meeting can be done in the same room or not
        // Greedily we will pick the meeting whose end time is minimum
        intervals.sort((a,b) -> Integer.compare(a.end, b.end));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Interval i : intervals){
            int endTime = i.end;
            if(minHeap.isEmpty()){ // No room is taken till now
                minHeap.offer(endTime);
            }
            else if(i.start < minHeap.peek()){ // New room created
                minHeap.offer(i.end);
            }
            else{ // Old room has been used
                minHeap.poll();
                minHeap.offer(i.end);
            }
        }
        return minHeap.size();


        // intervals.sort((a, b) -> a.start - b.start);
        // PriorityQueue<int[]> minHeapEndTime = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        // for(int i=0 ; i<intervals.size() ; i++){
        //     int startTime = intervals.get(i).start;
        //     int endTime = intervals.get(i).end;
        //     if(minHeapEndTime.isEmpty()){
        //         minHeapEndTime.offer(new int[]{startTime, endTime});
        //     }
        //     else{
        //         int[] prevMeet = minHeapEndTime.poll();
        //         if(prevMeet[1] <= startTime){
        //             minHeapEndTime.offer(new int[]{startTime, endTime});
        //         }
        //         else{
        //             minHeapEndTime.offer(prevMeet);
        //             minHeapEndTime.offer(new int[]{startTime, endTime});
        //         }
        //     }
        // }
        // return minHeapEndTime.size();
    }
}
