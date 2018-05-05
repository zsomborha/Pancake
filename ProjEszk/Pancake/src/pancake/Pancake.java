package pancake;

import GameLogic.GameLogic;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pancake {

    public static void main(String[] args) {
        boolean test = false;
        try {
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
