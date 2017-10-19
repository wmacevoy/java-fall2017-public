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
    String [] args;
    App(String[] _args) {
        args=_args;
    }
    
    public static void main(String[] args) throws Exception {
        new App(args).run();
    }
    
    void run() throws Exception {
        System.out.println("hello world!");
    }
    
}
