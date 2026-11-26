class LRUCache {
    List<int[]> list;
    int maxCapacity;
    public LRUCache(int capacity) {
        maxCapacity = capacity;
        list = new ArrayList<>();
    }
    
    public int get(int key) {
        for(int i=0 ; i<list.size() ; i++){
            if(list.get(i)[0] == key){
                return list.get(i)[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        int index = -1;
        for(int i=0 ; i<list.size() ; i++){
            if(list.get(i)[0] == key){
                index = i;
                break;
            }
        }
        if(index == -1){
            if(list.size() == maxCapacity){
                list.remove(0);
            }
            list.add(new int[]{key, value});
        }
        else{
            list.remove(index);
            list.add(new int[]{key, value});
        }
    }
}
