/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GameLogic.GameLogic;
import GameLogic.Player;
import java.util.ArrayList;
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
public class ResultTest {
    
    public ResultTest() {
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
     * Test of setResults method, of class Result.
     */
    @Test
    public void testSetResults() {
        System.out.println("setResults");
        ArrayList<Player> p = new ArrayList<Player>();
        p.add(new Player("A"));
        p.add(new Player("B"));
        p.add(new Player("C"));
        Result instance = new Result("My", p);
        instance.setResults(p);

    }

    /**
     * Test of setWinner method, of class Result.
     */
    @Test
    public void testSetWinner() {
        System.out.println("setWinner");
        ArrayList<Player> p = new ArrayList<Player>();
        p.add(new Player("A"));
        p.add(new Player("B"));
        p.add(new Player("C"));
        Result instance = new Result("My", p);
        instance.setWinner(p);

    }

    /**
     * Test of setModell method, of class Result.
     */
    @Test
    public void testSetModell() throws Exception {
        System.out.println("setModell");
        Modell aThis = new Modell(new GameLogic(false));
        ArrayList<Player> p = new ArrayList<Player>();
        p.add(new Player("A"));
        p.add(new Player("B"));
        Result instance = new Result("MyName", p);
        instance.setModell(aThis);

    }
    
}
