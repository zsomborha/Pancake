/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pancake;

import GameLogic.GameLogic;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gépecske
 */
public class Pancake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            GameLogic gameLogic = new GameLogic();
        } catch (Exception ex) {
            Logger.getLogger(Pancake.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
