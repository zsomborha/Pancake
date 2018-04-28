package GameLogic;


import GameLogic.GameLogic;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hartmann Zsombor
 */
public class TestGUI {
    
    GameLogic gameLogic;
    static Random rand = new Random();
    
    public static void main(String[] args) throws Exception{
        
        GameLogic gameLogic = new GameLogic(true);   
        
    }

    TestGUI(int parseInt, String ip, String playerName, GameLogic aThis) {
        gameLogic = aThis;
        
        System.out.println("IP: "+ip);
        System.out.println("PORT: "+parseInt);
        if(parseInt>65535 || parseInt<1){
            System.err.println("THIS PORT IS NOT AVAILABELE");
        }
        
        //Clients connection
        for(int i=0;i<3;i++){
            waitFourSecounds();
            gameLogic.statusZero();
        }
        waitFourSecounds();
        
        //Clients are ready, gamepanel create
        gameLogic.statusOne();
        
        waitTenSecounds();
        
        //Result display show
        gameLogic.statusThree();
        
        
    }

    private void waitFourSecounds() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void waitTenSecounds() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static int getQuestionID() {

        int n = rand.nextInt(2) + 1;
        System.out.println("Question ID: "+n);
        return n;
    }

    static void setSelectedAnswer(String answer) {
        System.out.println("Answer from GUI: "+answer);
        
        
    }

    static ArrayList<Player> getPlayers() {
        ArrayList<Player> p = new ArrayList<>();
        p.add(new Player("User1"));
        p.add(new Player("User2"));
        p.add(new Player("User3"));
        p.get(0).setPoints(10);
        p.get(1).setPoints(11);
        p.get(2).setPoints(9);
        return p;
    }
    
    
    
}
