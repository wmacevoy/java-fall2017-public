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
public class App {

    String[] args;

    App(String[] _args) {
        args = _args;
    }

    public static void main(String[] args) throws Exception {
        new App(args).run();
    }

    void run() throws Exception {
        Tweeter tweeter = new Tweeter();
        TempAlarm tempAlarm = new TempAlarm(tweeter);
        SlowQueryAlarm slowQueryAlarm = new SlowQueryAlarm(tweeter);
        tempAlarm.start();
        slowQueryAlarm.start();

        for (int i = 0; i < 10; ++i) {
            synchronized (tweeter) {
                tweeter.setMessage("hi # " + i);
                tweeter.setUser("user # " + i);
                tweeter.tweetInBackground();
            }
        }
        System.out.println("done in main.");
    }

}
