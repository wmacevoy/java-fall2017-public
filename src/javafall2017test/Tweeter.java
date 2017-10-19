/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017test;

/**
 *
 * @author wmacevoy
 */
public class Tweeter {
    private class Job implements Runnable {
        private String user;
        private String message;
        Job() {
            this.user=Tweeter.this.user;
            this.message=Tweeter.this.message;
        }

        void tweet() {
        try {
        System.out.println("connecting to twitter...");
        Thread.sleep(1000);
        System.out.println("transferring message...");
        Thread.sleep(1000);
        System.out.println("done!");
        System.out.println("tweeted: " + message + " for " + user);
        } catch (InterruptedException ex) {            
        }
        }

        @Override
        public void run() {
            tweet();
        }
    }
    
    private String user;
    private String message;
    public void setMessage(String _message) {
        message=_message;
    }
    public void setUser(String _user) {
        user=_user;
    }
    
    public void tweetInForeground() {
        new Job().tweet();
    }
    
    public void tweetInBackground() {
        Job job = new Job();
        Thread thread = new Thread(job);
        thread.start();
    }
    
    public void tweetInForeground(String user, String message) {
        synchronized(this) {
            setUser(user);
            setMessage(message);
            tweetInBackground();
        }
    }
}
