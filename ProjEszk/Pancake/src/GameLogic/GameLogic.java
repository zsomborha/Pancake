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
import java.util.List;

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
    
    public static void main(String[] args) throws Exception{ GameLogic g = new GameLogic();}
    
    public GameLogic() throws Exception{
        modell = new Modell(this);
        /*
        List<Question> list;
        list = DataSource.getInstance().getQuestionController().getEntities();
        list.get(1).getQuestionString();
        */
        

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
    
    public void allClientsReady(int round) throws SQLException{
        modell.GamePanelCreate(round);
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
