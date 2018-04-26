/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Client.Client;
import GameLogic.GameLogic;
import GameLogic.Player;
import Server.ServerStarter;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
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
               
        gameLogic.startCommunication(playerName,ip,port);
        l.dispose();
        System.out.println("startNewGame");
        waiting = new Waiting();
        waiting.setSize(1130, 710);
        waiting.setModell(this);
        this.playerName=playerName;

    }
    
    
    public void GamePanelCreate(int round) throws SQLException{
        this.round=round;
        waiting.dispose();
        String[] question = gameLogic.getQuestion();
        gamePanel = new GamePanel(this,round,playerName,question[0],question[1],question[2],question[3],question[4]);
        gamePanel.setSize(1130, 710);
        try {
            Thread.sleep(200);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Modell.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    void seAnswer(String answer) {

        gameLogic.sendAnswer(answer);
        if (kerdesSorszam<round){
        }else{
           gamePanel.playEndMessage();
        }
        
    }
    


    void startGameDescrition() {
        if (gameDescripton==null){
            gameDescripton = new GameDescription();
        }
        else{
            gameDescripton.show();
            
        }
    }

    public void newPlayer() {
        try{
            Thread.sleep(250);
            waiting.newPlayer();
        }catch(Exception ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void startNewSzerver(String toString) {
        
        ServerStarter.main(null);
  
    }

    public void serverAddress(int port) {
        l.MakeServerPortMessage(Integer.toString(port));
    }

    String[][] getResults() {
        ArrayList<Player> list = gameLogic.getResult();
        String[][] results = new String[list.size()][];
        
        for(int i=0;i<list.size();i++){
            results[i][0] = list.get(i).GetName();
            results[i][1] = Integer.toString(list.get(i).GetPoints());
        }
        return results;
    }

    public void endOfQuestion(ArrayList<Player> p) {
        gamePanel.dispose();
        result= new Result(playerName,p);
    }



    void startGame() {
        try {
            GamePanelCreate(10);
            
        } catch (Exception ex) {
            Logger.getLogger(Modell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    public void refreshQuestion() {
        try {
            gamePanel.setKerdesSorszam(++kerdesSorszam,round);
            String[] question = gameLogic.getQuestion();
            gamePanel.setNewQuestion(question[0],question[1],question[2],question[3],question[4]);
        } catch (SQLException ex) {
            Logger.getLogger(Modell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    
 
    
    
}
