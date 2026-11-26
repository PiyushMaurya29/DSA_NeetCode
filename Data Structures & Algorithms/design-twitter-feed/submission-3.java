class Twitter {
    Map<Integer, Set<Integer>> userFollowersMap;
    Map<Integer, List<int[]>> userTweetMap;
    int tweetTime;
    public Twitter() {
        userFollowersMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        tweetTime = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetTime++;
        if(!userTweetMap.containsKey(userId)){
            userTweetMap.put(userId, new ArrayList<>());
        }
        userTweetMap.get(userId).add(new int[]{tweetTime, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> list = new ArrayList<>();
        for(int[] p : userTweetMap.get(userId)){
            list.add(p);
        }
        if(userFollowersMap.containsKey(userId)){
            for(int f : userFollowersMap.get(userId)){
                for(int[] p : userTweetMap.get(f)){
                    list.add(p);
                }
            }
        }
        Collections.sort(list, (a,b) -> Integer.compare(b[0], a[0]));

        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<Math.min(10, list.size()) ; i++){
            result.add(list.get(i)[1]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userFollowersMap.containsKey(followerId)){
            userFollowersMap.put(followerId, new HashSet<>());
        }
        userFollowersMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // userFollowersMap.get(followerId).remove(followeeId);
        if(userFollowersMap.containsKey(followerId)){
            userFollowersMap.get(followerId).remove(followeeId);
        }
    }
}
