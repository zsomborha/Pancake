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
public class GamePanelTest {
    
    public GamePanelTest() {
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
     * Test of setModell method, of class GamePanel.
     */
    @Test
    public void testSetModell() throws Exception {
        System.out.println("setModell");
        GameLogic g = new GameLogic(false);
        Modell m = new Modell(g);
        Modell aThis = m;
        GamePanel instance = new GamePanel(m, 0, "playerName", "kerdes", "valasz1", "valasz2", "valasz3", "valasz4");
        instance.setModell(aThis);

    }

    /**
     * Test of setNewQuestion method, of class GamePanel.
     */
    @Test
    public void testSetNewQuestion() throws Exception {
        System.out.println("setNewQuestion");
        GameLogic g = new GameLogic(false);
        Modell m = new Modell(g);
        
        String string = "a";
        String string0 = "b";
        String string1 = "c";
        String string2 = "d";
        String string3 = "e";
        GamePanel instance = new GamePanel(m, 0, "playerName", "kerdes", "valasz1", "valasz2", "valasz3", "valasz4");
        instance.setNewQuestion(string, string0, string1, string2, string3);

    }

    /**
     * Test of setKerdesSorszam method, of class GamePanel.
     */
    @Test
    public void testSetKerdesSorszam() throws Exception {
        System.out.println("setKerdesSorszam");
        int n = 0;
        int round = 0;
        GameLogic g = new GameLogic(false);
        Modell m = new Modell(g);
        GamePanel instance = new GamePanel(m, 0, "playerName", "kerdes", "valasz1", "valasz2", "valasz3", "valasz4");
        instance.setKerdesSorszam(n, round);

    }
    
}
