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
public class Tweeter {
    ArrayList<String> log = new ArrayList<String>();
        
        public int getLogSize() { return log.size(); }
        
        public String getLogEntry(int index) {
            if (0 <= index && index < log.size()) return log.get(index);
            return null;
        }
    public String getMessage() {
        return message;
    }
    
    private class Job implements Runnable {

        private String user;
        private String message;
        
        

        Job() {
            this.user = Tweeter.this.user;
            this.message = Tweeter.this.message;
        }
        
        void log(String message) {
            log.add(message);
            System.out.println(message);
        }

        void tweet() {
            try {
                log("connecting to twitter...");
                Thread.sleep(1000);
                log("transferring message...");
                Thread.sleep(1000);
                log("done!");
                log("tweeted: " + message + " for " + user);
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
        message = _message;
    }

    public void setUser(String _user) {
        user = _user;
    }

    public void tweetInForeground() {
        new Job().tweet();
    }

    public Thread tweetInBackground() {
        Job job = new Job();
        Thread thread = new Thread(job);
        thread.start();
        return thread;
    }

    public void tweetInForeground(String user, String message) {
        synchronized (this) {
            setUser(user);
            setMessage(message);
            tweetInForeground();
        }
    }

    public Thread tweetInBackground(String user, String message) {
        synchronized (this) {
            setUser(user);
            setMessage(message);
            return tweetInBackground();
        }
    }
}
