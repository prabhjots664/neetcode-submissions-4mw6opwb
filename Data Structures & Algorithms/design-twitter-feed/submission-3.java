
class Twitter {

    Map<Integer, Set<Integer>> followings;
    int timeStamp;
    Map<Integer, List<Integer[]>> userTweets;

    public Twitter() {
        followings = new HashMap<>();
        timeStamp = 0;
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        timeStamp++;

        if(!userTweets.containsKey(userId)){
            userTweets.put(userId, new ArrayList<>());
        }

        userTweets.get(userId).add(new Integer[]{tweetId, timeStamp});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        Set<Integer> allRelevantUsers = followings.get(userId);
        if( allRelevantUsers==null || allRelevantUsers.isEmpty()){
            allRelevantUsers = new HashSet<>();
        }
        allRelevantUsers.add(userId);

        for (Integer uId: allRelevantUsers){
            List<Integer[]> tweets = userTweets.get(uId);
            if(tweets==null){
                tweets = new ArrayList<>();
            }
            for (int i = 0; i < tweets.size(); i++) {
                pq.offer(tweets.get(i));
            }
            
        }

        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (!pq.isEmpty() && i<10){
            res.add(pq.poll()[0]);
            i++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!followings.containsKey(followerId)){
            followings.put(followerId, new HashSet<>());
        }
        followings.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followings.get(followerId).remove(followeeId);
    }
}
