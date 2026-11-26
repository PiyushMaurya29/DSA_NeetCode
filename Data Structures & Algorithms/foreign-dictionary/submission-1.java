class Solution {
    public String foreignDictionary(String[] words) {
        boolean[] isPresent = new boolean[26];
        for(String word : words){
            for(char c : word.toCharArray()){
                isPresent[c-'a'] = true;
            }
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0 ; i<26 ; i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[26];
        for(int i=1 ; i<words.length ; i++){
            String prev = words[i-1];
            String curr = words[i];
            if(prev.length()>curr.length() && prev.substring(0, curr.length()+1).equals(curr)){
                return "";
            }
            for(int j=0 ; j<Math.min(prev.length(), curr.length()) ; j++){
                int c1 = prev.charAt(j);
                int c2 = curr.charAt(j);
                if(c1 != c2){
                    adjList.get(c1-'a').add(c2-'a');
                    inDegree[c2-'a']++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<26 ; i++){
            if(isPresent[i] && inDegree[i]==0){
                queue.offer(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.append((char)(curr+'a'));
            for(int adjNode : adjList.get(curr)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }
        return result.toString();
    }
}
