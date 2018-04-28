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
        boolean test = false;
        try {
            // TODO code application logic here
            if (args.length>0 && args[0].equals("test")){
                test=true;
            }
            GameLogic gameLogic = new GameLogic(test);
        } catch (Exception ex) {
            Logger.getLogger(Pancake.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("HIBA");
        }
    }
    
}
