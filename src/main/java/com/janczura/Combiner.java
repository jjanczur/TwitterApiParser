package com.janczura;

import com.janczura.tweets.TweetsResearcher;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Combiner {
    public static void main(String[] args) {
        String username = args[0]; //"unisyscorp";
        int numberOfTweets = Integer.parseInt(args[1]); //
        String filename = username+"Tweets"+".csv";
        System.out.println("username: " + username);
        System.out.println("numberOfTweets: " + numberOfTweets);
        numberOfTweets = numberOfTweets / 200;

        TweetsResearcher tweetsResearcher = new TweetsResearcher();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int i = 1; i <= numberOfTweets; i++) {
                List<Status> statuses = tweetsResearcher.getUsersTweets(username, i);
                for (Status status : statuses) {
                    index++;
                    sb.append(index).append(";").
                            append(status.getUser().getName()).append(";").
                            append(status.getUser().getScreenName()).append(";").
                            append(status.getCreatedAt()).append(";").
                            append(status.getText()).
                            append("\n");
                }
            }
            writer.write(sb.toString());

            System.out.println("Pobralem tweety");
            System.out.println("Plik z tweetami utworzony: " + filename);
            System.exit(0);
        } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println("Failed to get timeline: " + e.getMessage());
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
