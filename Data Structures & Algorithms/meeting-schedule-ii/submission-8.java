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
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        List<Integer> list = new ArrayList<>();
        for(var i : intervals){
            int start = i.start;
            int end = i.end;
            int index = -1;
            for(int k=0 ; k<list.size() ; k++){
                if(start >= list.get(k)){
                    index = k;
                    break;
                }
            }
            if(index == -1) list.add(end);
            else list.set(index, end);
        }
        return list.size();
    }
}
