class Twitter {

    class Tweet {
        int time;
        int tweetId;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> post;
    private int time;

    public Twitter() {
        following = new HashMap<>();
        post = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        post.putIfAbsent(userId, new ArrayList<>());

        Tweet newTweet = new Tweet(tweetId, time++);

        post.get(userId).add(newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        if (post.containsKey(userId)) {
            for (Tweet tw : post.get(userId)) {
                pq.offer(tw);
            }
        }

        if (following.containsKey(userId)) {

            for (int followee : following.get(userId)) {

                if (post.containsKey(followee)) {

                    for (Tweet tw : post.get(followee)) {
                        pq.offer(tw);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().tweetId);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        
        if (followerId == followeeId) {
            return;
        }

        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}