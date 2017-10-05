/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author wmacevoy
 */
public class App {
    String [] args;
    App(String[] _args) {
        args = _args;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        App app = new App(args);
        app.run();
    }
    
    void arrays() {
        boolean [] p = new boolean[10];
        boolean [] q = new boolean [] { true, true, false };
        String [] s = new String[10];
        s[0]="this";
        boolean [][] pixmax = new boolean [1024][2048];
        
        boolean [][] ragged = new boolean[10][];
        ragged[0] = new boolean[44];
        ragged[1] = new boolean[12];
        
    }
    
    ArrayList<Boolean> booleanArray(int size) {
        ArrayList < Boolean > ans = new ArrayList < Boolean > (size);
        for (int i=0; i<size; ++i) {
            ans.add(Boolean.TRUE);
        }
        return ans;
    }
    
    void collections() {
        ArrayList < Boolean > p = new ArrayList < Boolean > (10);
        p.add(Boolean.TRUE);
        
    }
    
    void run() throws Exception {
        System.out.println("args: " + Arrays.toString(args));
    }
    
}
