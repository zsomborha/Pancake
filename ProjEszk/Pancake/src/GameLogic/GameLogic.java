/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import Client.Client;
import Database.DataSource;
import Database.Entities.Question;
import GUI.Modell;
import Server.Server;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barish Arianna
 */
public class GameLogic {

    public static void closeconnection() {
        //client.closeConnection();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void startGame() {
        server.startGame();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Modell modell;
    Client client;
    static Server server;
    
    public static void main(String[] args) throws Exception{ GameLogic g = new GameLogic();}
    
    public GameLogic() throws Exception{
        modell = new Modell(this);
    }
    

    
    public static void statusChange(int status){
        System.out.println(status);
    }
    

    
    public void statusZero(){
        //itt csatalozik uj jatekos
        modell.newPlayer();
    }
    
    public void statusOne(){
        try {
            modell.GamePanelCreate(10);
        } catch (SQLException ex) {
            Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void statusTwo(){    
            //end of question
        modell.endOfQuestion();
    }

    public void statusThree(){    
            //end of question
            
    }
    
    public void startCommunication(String playerName, String ip, String port) {
        client = new Client(Integer.parseInt(port), ip, playerName,this);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    


    public String[] getQuestion() throws SQLException {

        int index = client.getQuestionID();
        Question myQuestion = DataSource.getInstance().getQuestionController().getEntityById(index);
        List<String> answers = myQuestion.getAnswers();
        
        
        //String[] questionWithAnswers = {"Mi a helyes valasz?", "Egy", "ketto", "harom", "negy"};
        String[] questionWithAnswers = {myQuestion.getQuestionString(), answers.get(0), answers.get(1), answers.get(2), answers.get(3)};
        
        return questionWithAnswers;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sendAnswer(int answer) {
          client.setSelectedAnswer(answer);    
    }
    
    

     



    public ArrayList getResult() {
        
        return client.getPlayers();
    }

    public void startSzerver(int parseInt) {
        server = new Server(parseInt, 10,5);
        modell.serverAddress(server.getPORT());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    
    
    
    
}
