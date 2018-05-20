package pancake;

import GameLogic.GameLogic;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pancake {

    public static void main(String[] args) {
        boolean test = false;
        
        if(args.length == 0){
            try {
                if (args.length>0 && args[0].equals("test")){
                    test=true;
                }
                GameLogic gameLogic = new GameLogic(test);
            } catch (Exception ex) {
                Logger.getLogger(Pancake.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("HIBA");
            }
        }else{
            if(args[0].equals("s")){
                pancake_server.Pancake_server.main(args);
            }else if(args[0].equals("d")){
                pancake_database.Pancake_database.main(args);
            } 
        }
        
    }
    
}
