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
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b[0], a[0]);
        });
        for(int i=0 ; i<26 ; i++){
            if(freq[i]>0){
                maxHeap.offer(new int[]{freq[i], i});
            }
        }
        StringBuilder result = new StringBuilder();
        while(maxHeap.size() >= 2){
            int[] first = maxHeap.poll();
            int f1 = first[0];
            char c1 = (char)('a'+first[1]);

            int[] second = maxHeap.poll();
            int f2 = second[0];
            char c2 = (char)('a'+second[1]);

            result.append(c1).append(c2);

            if(f1 > 1){
                maxHeap.offer(new int[]{f1-1, c1-'a'});
            }
            if(f2 > 1){
                maxHeap.offer(new int[]{f2-1, c2-'a'});
            }
        }
        if(maxHeap.isEmpty()) return result.toString();
        
        int[] curr = maxHeap.poll();
        if(curr[0] > 1) return "";
        result.append((char)(curr[1]+'a'));
        return result.toString();




        // Map<Character, Integer> map = new HashMap<>();
        // for(char c : s.toCharArray()){
        //     map.put(c, map.getOrDefault(c, 0)+1);
        // }

        // PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        // for(char c : map.keySet()){
        //     int freq = map.get(c);
        //     maxHeap.offer(new Pair(c, freq));
        // }

        // StringBuilder result = new StringBuilder();
        // while(maxHeap.size() >= 2){
        //     Pair p1 = maxHeap.poll();
        //     Pair p2 = maxHeap.poll();

        //     // result.append(p1.c);
        //     // result.append(p2.c);

        //     if(result.length() == 0){
        //         result.append(p1.c);
        //         result.append(p2.c);
        //     }
        //     else{
        //         if(result.charAt(result.length()-1) != p1.c){
        //             result.append(p1.c);
        //             result.append(p2.c);
        //         }
        //         else{
        //             result.append(p2.c);
        //             result.append(p1.c);
        //         }
        //     }

        //     if(p1.freq > 1){
        //         maxHeap.offer(new Pair(p1.c, p1.freq-1));
        //     }
        //     if(p2.freq > 1){
        //         maxHeap.offer(new Pair(p2.c, p2.freq-1));
        //     }
        // }
        // if(maxHeap.isEmpty()) return result.toString();
        // Pair p = maxHeap.poll();
        // if(p.freq > 1) return "";
        // else result.append(p.c);

        // return result.toString();

    }
}