class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], b[1]));
        for(int key : map.keySet()){
            int freq = map.get(key);
            minHeap.offer(new int[]{key, freq});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()){
            result[index++] = minHeap.poll()[0];
        }
        return result;



        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }

        // List<int[]> list = new ArrayList<>();
        // for(int key : map.keySet()){
        //     int freq = map.get(key);
        //     list.add(new int[]{key, freq});
        // }
        // Collections.sort(list, (a,b) -> Integer.compare(b[1], a[1]));

        // int[] result = new int[k];
        // for(int i=0 ; i<k ; i++){
        //     result[i] = list.get(i)[0];
        // }
        // return result;
    }
}
