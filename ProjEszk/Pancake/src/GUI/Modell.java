/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hartmann Zsombor
 */
public class Modell {
    
    login l;
    Waiting waiting;
    GamePanel gamePanel;
    String playerName;
    private int kerdesSorszam = 1;
    
    public static void main(String[] args){
                        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modell();
            }
        });
        
        
    }
    
    public Modell(){
        System.out.println("Modell start");
        l= new login();
        l.setModell(this);
  
    }



    void startNewGame(String playerName) {
        if (playerName.isEmpty()){
            l.sendUserMessage();
            return;
        }
        //TODO CLIENT STARTNEWGAME
        l.dispose();
        System.out.println("startNewGame");
        waiting = new Waiting();
        this.playerName=playerName;
        waitFiveSecounds();
        GamePanelCreate();
    }
    
    
    void GamePanelCreate(){
        waiting.dispose();
        //String[] question = client.getQuestion();
        String[] question = {"elso kerdes","A","B","C","D"};
        gamePanel = new GamePanel(playerName,question[0],question[1],question[2],question[3],question[4]);
        gamePanel.setModell(this);
        
    }
    
    void waitFiveSecounds(){
                try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Modell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void seAnswer(String answer) {
        //client.sendAnswer(answer)
        //String[] question = client.getQuestion();
        String[] question = {"x kerdes","Aa","Ba","Ca","Da"};
        gamePanel.setNewQuestion(question[0],question[1],question[2],question[3],question[4]);
        gamePanel.setKerdesSorszam(++kerdesSorszam);
    }
    
    
}
