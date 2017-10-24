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
public class Tweet {
    String user;
    String body;
    Tweet(String _user, String _body) {
        user=_user;
        body=_body;
    }
    @Override public String toString() {
        return "tweet: user" + user + " message=" + body;
    }
}
