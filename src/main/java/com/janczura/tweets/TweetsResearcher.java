package com.janczura.tweets;

import twitter4j.*;

import java.util.List;
import java.util.stream.Collectors;

public class TweetsResearcher {
    public static Twitter getTwitterinstance() {

        Twitter twitter = TwitterFactory.getSingleton();
        return twitter;

    }
    public List<String> getTimeLine() throws TwitterException {
        Twitter twitter = getTwitterinstance();

        return twitter.getHomeTimeline().stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

    public List<Status> getUsersTweets(String username, int page) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        Paging paging = new Paging(page, 200);
        return twitter.getUserTimeline(username, paging);
    }
}
