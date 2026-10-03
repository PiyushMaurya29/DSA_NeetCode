class Solution {
    class Pair{
        char c;
        int freq;
        Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        for(char c : map.keySet()){
            int freq = map.get(c);
            maxHeap.offer(new Pair(c, freq));
        }

        StringBuilder result = new StringBuilder();
        while(maxHeap.size() >= 2){
            Pair p1 = maxHeap.poll();
            Pair p2 = maxHeap.poll();

            // result.append(p1.c);
            // result.append(p2.c);

            if(result.length() == 0){
                result.append(p1.c);
                result.append(p2.c);
            }
            else{
                if(result.charAt(result.length()-1) != p1.c){
                    result.append(p1.c);
                    result.append(p2.c);
                }
                else{
                    result.append(p2.c);
                    result.append(p1.c);
                }
            }

            if(p1.freq > 1){
                maxHeap.offer(new Pair(p1.c, p1.freq-1));
            }
            if(p2.freq > 1){
                maxHeap.offer(new Pair(p2.c, p2.freq-1));
            }
        }
        if(maxHeap.isEmpty()) return result.toString();
        Pair p = maxHeap.poll();
        if(p.freq > 1) return "";
        else result.append(p.c);

        return result.toString();

    }
}