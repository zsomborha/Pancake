/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUITest;

import GUI.Modell;
import GameLogic.GameLogic;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Arianna
 */
public class GUITest {
    
    @Test(expected = NullPointerException.class)
    public void ModellThrowsExceptionOnNull() {
        GameLogic gamelogic = null;
        Modell modell = new Modell(gamelogic);
    }
    
    
    
    /*
    @Test
    public void startNewGameEmptyName() throws Exception{
        GameLogic g = new GameLogic();
        Modell modell = new Modell(g);
        modell.startNewGame("", "127.0.0.1", "12345");
        assertEquals(  , "A nev mezo kitoltese kotelezo!" );
        
    }
    */
    
}
