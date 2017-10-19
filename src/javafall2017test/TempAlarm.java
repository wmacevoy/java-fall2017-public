/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wmacevoy
 */
public class TempAlarm extends Thread {

    Tweeter tweeter;

    TempAlarm(Tweeter _tweeter) {
        tweeter = _tweeter;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TempAlarm.class.getName()).log(Level.SEVERE, null, ex);
            }
            synchronized (tweeter) {
                tweeter.setUser("buiding admin");
                try {
                    Thread.sleep((int) Math.random() * 100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SlowQueryAlarm.class.getName()).log(Level.SEVERE, null, ex);
                }
                tweeter.setMessage("too hot!");
                tweeter.tweetInBackground();
            }
        }
    }
}
