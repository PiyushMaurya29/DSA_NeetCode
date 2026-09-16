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
        // Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for(Interval i : intervals){
        //     int start = i.start;
        //     int end = i.end;
        //     while(!minHeap.isEmpty() && minHeap.peek()<=start){
        //         minHeap.poll();
        //     }
        //     minHeap.offer(end);
        // }
        // return minHeap.size();



        // Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for(Interval i : intervals){
        //     int start = i.start;
        //     int end = i.end;
        //     if(minHeap.isEmpty()){
        //         minHeap.offer(end);
        //     }
        //     else{
        //         if(minHeap.peek()<=start){
        //             minHeap.poll();
        //         }
        //         minHeap.offer(end);
        //     }
        // }
        // return minHeap.size();



        int[] mark = new int[1000001];
        for(Interval i : intervals){
            int start = i.start;
            int end = i.end;
            mark[start]++;
            mark[end]--;
        }
        int result = 0;
        for(int i=1 ; i<mark.length ; i++){
            mark[i] += mark[i-1];
            result = Math.max(result, mark[i]);
        }
        return result;


        // Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        // List<Integer> list = new ArrayList<>();
        // for(var i : intervals){
        //     int start = i.start;
        //     int end = i.end;
        //     int index = -1;
        //     for(int k=0 ; k<list.size() ; k++){
        //         if(start >= list.get(k)){
        //             index = k;
        //             break;
        //         }
        //     }
        //     if(index == -1) list.add(end);
        //     else list.set(index, end);
        // }
        // return list.size();
    }
}
