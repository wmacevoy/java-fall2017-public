/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wmacevoy
 */
public class TweeterTest {
    
    public TweeterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setMessage method, of class Tweeter.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String _message = "test message";
        Tweeter instance = new Tweeter();
        instance.setMessage(_message);
        assertEquals(_message, instance.getMessage());
    }

    /**
     * Test of setUser method, of class Tweeter.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String _user = "";
        Tweeter instance = new Tweeter();
        instance.setUser(_user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tweetInForeground method, of class Tweeter.
     */
    @Test
    public void testTweetInForeground_0args() {
        System.out.println("tweetInForeground");
        Tweeter instance = new Tweeter();
        instance.tweetInForeground();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tweetInBackground method, of class Tweeter.
     */
    @Test
    public void testTweetInBackground_0args() {
        System.out.println("tweetInBackground");
        Tweeter instance = new Tweeter();
        instance.setMessage("test message");
        instance.setUser("test user");
        Thread thread=instance.tweetInBackground();
        try {
            thread.join();
        } catch (InterruptedException ex) {}
        assertEquals("tweeted: test message for test user",
                instance.getLogEntry(instance.getLogSize()-1));
    }

    /**
     * Test of tweetInForeground method, of class Tweeter.
     */
    @Test
    public void testTweetInForeground_String_String() {
        System.out.println("tweetInForeground");
        String user = "";
        String message = "";
        Tweeter instance = new Tweeter();
        instance.tweetInForeground(user, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tweetInBackground method, of class Tweeter.
     */
    @Test
    public void testTweetInBackground_String_String() {
        System.out.println("tweetInBackground");
        String user = "";
        String message = "";
        Tweeter instance = new Tweeter();
        instance.tweetInBackground(user, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
