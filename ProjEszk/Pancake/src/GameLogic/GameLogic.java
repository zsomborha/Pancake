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
    
    static Modell modell;
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
    
    public static void statusOne(){
        try {
            modell.GamePanelCreate(10);
        } catch (SQLException ex) {
            Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void statusChange(int status){
        System.out.println(status);
       // if (status)
    }
    
    public void newPlayerJoined(){
        modell.newPlayer();
    }
    
    public sattic void statusZero(//nincs){
        //itt csatalozik uj jatekos
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
          client.setSelectedAnswer(0);
          
        
    }
    
    public void endOfQuestions(){
        
    }

    public String[][] getResult() {
        //return client.getResult();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public void startSzerver(int parseInt) {
        Server server = new Server(parseInt, 10,5);
        modell.serverAddress(server.getPORT());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    
    
    
    
}
