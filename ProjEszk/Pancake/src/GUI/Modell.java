/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Client.Client;
import GameLogic.GameLogic;
import java.awt.Toolkit;
import java.sql.SQLException;
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
    Client client;
    GameLogic gameLogic;
  
    


    public Modell(GameLogic aThis) {
       
        System.out.println("Modell start");
        l= new login();
        l.setSize(1130, 710);
        l.setModell(this);
        gameLogic=aThis;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    void startNewGame(String playerName, String ip, String port) {
        if (playerName.isEmpty()){
            l.sendUserMessage();
            return;
        }
        try{
            Integer.parseInt(port);
        }catch(Exception e){
            l.sendUserPortMessage();
            return;
        }
        
        if (ip.isEmpty()){
            l.sendUserIpMessage();
            return;
        }
        
        
        //TODO CLIENT STARTNEWGAME
        
        gameLogic.startCommunication(playerName,ip,port);
        l.dispose();
        System.out.println("startNewGame");
        waiting = new Waiting();
        waiting.setSize(1130, 710);
        this.playerName=playerName;
      //  waitFiveSecounds();
      //  GamePanelCreate();
    }
    
    
    public void GamePanelCreate(int round) throws SQLException{
        this.round=round;
        waiting.dispose();
        String[] question = gameLogic.getQuestion();
        //String[] question = {"elso kerdes","A","B","C","D"};
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
        gameLogic.sendAnswer(answer);
        if (kerdesSorszam<round){
           String[] question;
            try {
                question = gameLogic.getQuestion();
                gamePanel.setNewQuestion(question[0],question[1],question[2],question[3],question[4]);
            } catch (SQLException ex) {
                Logger.getLogger(Modell.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           gamePanel.setKerdesSorszam(++kerdesSorszam,round);
        }else{
           gamePanel.playEndMessage();
           String[][] results= gameLogic.getResult();
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
        GameLogic.closeconnection();
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

    public void newPlayer() {
        waiting.newPlayer();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void startNewSzerver(String toString) {
        try{
           gameLogic.startSzerver(Integer.parseInt(toString)); 
        }catch (Exception e){
            System.err.println("Illegal number format");
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void serverAddress(int port) {
        l.MakeServerPortMessage(Integer.toString(port));
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
 
    
    
}
