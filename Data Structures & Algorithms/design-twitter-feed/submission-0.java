class Twitter {
    class Tweet{
        Tweet next;
        int tweetTime;
        int tweetId;
        Tweet(int tweetTime, int tweetId){
            this.tweetTime = tweetTime;
            this.tweetId = tweetId;
        }
    }

    int tweetTime;
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, Tweet> userTweetMap;
    public Twitter() {
        tweetTime = 0;
        followerMap = new HashMap<>();
        userTweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userTweetMap.containsKey(userId)){
            userTweetMap.put(userId, new Tweet(tweetTime++, tweetId));
        }
        else{
            Tweet newTweet = new Tweet(tweetTime++, tweetId);
            newTweet.next = userTweetMap.get(userId);
            userTweetMap.put(userId, newTweet);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.tweetTime, a.tweetTime));
        if(userTweetMap.containsKey(userId)){
            maxHeap.offer(userTweetMap.get(userId));
        }

        Set<Integer> followerSet = followerMap.get(userId);
        if(followerSet != null){
            for(int f : followerSet){
                Tweet t = userTweetMap.get(f);
                if(t != null){
                    maxHeap.offer(t);
                }
            }
        }
        while(!maxHeap.isEmpty() && result.size()<10){
            Tweet t = maxHeap.poll();
            result.add(t.tweetId);
            if(t.next != null){
                maxHeap.offer(t.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId)){
            followerMap.put(followerId, new HashSet<>());
        }
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followerSet = followerMap.get(followerId);
        if(followerSet != null){
            followerSet.remove(followeeId);
        }
    }
}
