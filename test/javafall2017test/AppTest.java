/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
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
public class AppTest {
    
    public AppTest() {
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
     * Test of main method, of class App.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main untested");
    }

    /**
     * Test of run method, of class App.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run untested");
    }
    
    @Test
    public void testConstruct() throws Exception {
        String [] args = new String[] { "a", "b", "c" };
        
        App app = new App(args);
        
        assertArrayEquals(args,app.args);
    }

    @Test
    public void testBooleanArray() {
        App app = new App(new String[] {});
        int size = 3;
        ArrayList<Boolean> result = app.booleanArray(size);
        assertEquals(size, result.size());
        for (int i=0; i<size; ++i) {
            assertEquals(true, result.get(i).booleanValue());
        }
        
        
    }
    @Test
    public void testCreateArrayListPixmap() {
        int rows = 1024;
        int cols = 2048;
        ArrayList < ArrayList < Boolean > > pixmap 
                = new ArrayList < ArrayList < Boolean > >(rows);
        
        for (int i=0; i<rows; ++i) {
            pixmap.add(new ArrayList<Boolean>(cols));
            for (int j=0; j<cols; ++j) {
                pixmap.get(i).add(Boolean.FALSE);
            }
        }
        
        int row = 3;
        int col = 15;
        pixmap.get(row).set(col,Boolean.TRUE);
    }
    
    @Test
    public void testDirectives() {
        Set<Directive> directives = new TreeSet < Directive> ();
        
        directives.add(new RelayDirective(10,true));
        directives.add(new RelayDirective(12,false));
        directives.add(new RelayDirective(12,true));
        directives.add(new RelayDirective(10,true));
        directives.add(new RelayDirective(8, false));
        
        for (Directive directive : directives) {
            System.out.println("directive: " + directive.description());
        }
    }
    
    static class CmpDirective implements Comparator < Directive > {
        @Override
        public int compare(Directive a, Directive b) {
            return a.compareTo(b);
        }
    }
    
    @Test
    public void testSortDirectives() {
        ArrayList<Directive> directives = new ArrayList < Directive> ();
        
        directives.add(new RelayDirective(10,true));
        directives.add(new RelayDirective(12,false));
        directives.add(new RelayDirective(10,true));
        directives.add(new RelayDirective(8, false));
        directives.add(new RelayDirective(12,true));
        
        directives.remove(new RelayDirective(12,false));
        
        directives.sort(new CmpDirective());

        directives.sort(new Comparator<Directive>() {
            @Override
            public int compare(Directive a, Directive b) {
                return -a.compareTo(b);
            }  
        });
        
        directives.sort((a,b)->a.compareTo(b));
        
        assertEquals(new RelayDirective(8, false), directives.get(0));
        assertEquals(new RelayDirective(10,true), directives.get(1));
        assertEquals(new RelayDirective(10,true), directives.get(2));
        assertEquals(new RelayDirective(12,true), directives.get(3));
    }
    
}
