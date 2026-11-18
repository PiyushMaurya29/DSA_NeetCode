class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)){
            return 0;
        }

        Set<String> wordSet = new HashSet<>();
        for(var w : wordList){
            wordSet.add(w);
        }
        if(!wordSet.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int level = 1;
        while(!queue.isEmpty()){
            level++;

            int levelSize = queue.size();
            while(levelSize-- > 0){
                char[] arr = queue.poll().toCharArray();
                for(int i=0 ; i<arr.length ; i++){
                    char oldChar = arr[i];
                    for(int j='a' ; j<='z' ; j++){
                        arr[i] = (char)j;
                        String str = new String(arr);
                        if(wordSet.contains(str)){
                            if(str.equals(endWord)){
                                return level;
                            }
                            wordSet.remove(str);
                            queue.offer(str);
                        }
                    }
                    arr[i] = oldChar; // Restore the old Character
                }
            }
        }
        return 0;

    }
}
