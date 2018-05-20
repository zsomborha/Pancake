/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GameLogic.GameLogic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hartmann Zsombor
 */
public class WaitingTest {
    
    public WaitingTest() {
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
     * Test of setModell method, of class Waiting.
     */
    @Test
    public void testSetModell() throws Exception {
        System.out.println("setModell");
        Modell modell = new Modell(new GameLogic(false));
        Waiting instance = new Waiting();
        instance.setModell(modell);

    }

    /**
     * Test of main method, of class Waiting.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Waiting.main(args);

    }


    
}
