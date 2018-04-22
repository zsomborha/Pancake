/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import Client.Client;
import GUI.Modell;
import Server.Server;

/**
 *
 * @author Barish Arianna
 */
public class GameLogic {

    public static void closeconnection() {
        //client.closeConnection();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Modell modell;
    Client client;
    
    public GameLogic(){
        modell = new Modell(this);

    }
    
    
    public static void statusChange(int status){
        System.out.println(status);
    }
    
    public void newPlayerJoined(){
        modell.newPlayer();
    }

    public void startCommunication(String playerName, String ip, String port) {
        client = new Client(Integer.parseInt(port), ip, playerName);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void allClientsReady(int round){
        modell.GamePanelCreate(round);
    }
    


    public String[] getQuestion() {
        //int QuestionId = client.getQuestionId;
        //TODO ADATBÁZISBÓL LEKÉRNI A KÉRDÉST
        String[] question = {"Mi a helyes valasz?", "Egy", "ketto", "harom", "negy"};
        return question;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sendAnswer(String answer) {
          //client.sendAnswer(answer);
        
    }
    
    public void endOfQuestions(){
        
    }

    public String[][] getResult() {
        //return client.getResult();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    


    
    
    
    
}
