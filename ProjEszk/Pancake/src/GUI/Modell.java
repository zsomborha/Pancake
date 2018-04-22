/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Toolkit;
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
    GameDescription gameDescripton;
    private int kerdesSorszam = 1;
    int round;
    Result result;
    
    public static void main(String[] args){
                        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modell(5);
            }
        });
        
        
    }
    
    public Modell(int round){
        this.round=round;
        System.out.println("Modell start");
        l= new login();
        l.setSize(1130, 710);
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
        waiting.setSize(1130, 710);
        this.playerName=playerName;
      //  waitFiveSecounds();
      //  GamePanelCreate();
    }
    
    
    void GamePanelCreate(){
        waiting.dispose();
        //String[] question = client.getQuestion();
        String[] question = {"elso kerdes","A","B","C","D"};
        gamePanel = new GamePanel(round,playerName,question[0],question[1],question[2],question[3],question[4]);
        gamePanel.setSize(1130, 710);
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
        gamePanel.setKerdesSorszam(++kerdesSorszam,round);
        if(kerdesSorszam>round){
            gamePanel.playEndMessage();
            gamePanel.dispose();
            result = new Result(playerName);
            result.setSize(1130, 710);
            result.setModell(this);
            String[][] results = { {"player1","5"},{"player2","13"},{"player3","3"}  };
            setResults(results);
        }
    }
    
    void setResults(String[][] results){
        result.setResults(results);
        String[] winner=results[0];
        for(int i=1;i<results.length;i++){
            if (Integer.parseInt(results[i][1]) > Integer.parseInt(winner[1])){
                winner = results[i];
            }
        }
        result.setWinner(winner);
    }

    void startGameDescrition() {
        if (gameDescripton==null){
            gameDescripton = new GameDescription();
           // gameDescripton.setSize(1130, 710);
        }
        else{
            gameDescripton.show();
            
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    
    
}
