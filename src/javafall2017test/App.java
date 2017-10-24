/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017test;

import java.util.ArrayList;

/**
 *
 * @author wmacevoy
 */
public class App {
    String [] args;
    App(String[] _args) {
        args=_args;
    }
    
    public static void main(String[] args) throws Exception {
        new App(args).run();
    }
    
    void run() throws Exception {
        ArrayList < Tweet > tweets = makeTweets(10);
        
        tweets.forEach(
                tweet -> {
                    System.out.println(tweet);
                }
        );
        
        tweets.parallelStream().forEach(tweet -> {
                    System.out.println(tweet);
                });
        
        tweets.parallelStream().filter(tweet -> 
                Integer.parseInt(tweet.user.substring(tweet.user.length()-1)) %2 == 0)
                .forEach(tweet -> {
                    System.out.println(tweet);
                });
        
        long total = tweets.parallelStream().mapToInt(tweet->
                Integer.parseInt(tweet.user.substring(tweet.user.length()-1)))
                .sum();
        
        long sum = 0;
        for (Tweet tweet : tweets) {
            int id = Integer.parseInt(tweet.user.substring(tweet.user.length()-1));
            sum += id;
        }
    }
    
    ArrayList < Tweet > makeTweets(int n) {
        ArrayList < Tweet > tweets = new ArrayList < Tweet > ();
        
        for (int i=0; i<n; ++i) {
            tweets.add(new Tweet("user # " + i, "message # " + i));
        }
        return tweets;
    }
    
}
