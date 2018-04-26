package Server;

import Database.DataSource;
import Database.Entities.Question;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private int PORT = 0;
    private ServerSocket ss;
    private int rounds;
    private int timePerQuestion = 10;
    private final int maxClients = 4;
    private boolean gameStart = false;
    private Thread joining;
    public ArrayList<User> players = new ArrayList<User>();
    
    public Server(int PORT,int rounds, int tpq){
        this.PORT = PORT;
        this.rounds = rounds;
        this.timePerQuestion = tpq;
        try {
            ss = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.err.println("Error at creating server: " + ex.toString());
        }
        
        Thread start = new Thread( () -> {
            synchronized(players){
                startServer();
            }
        } );
        
        start.start();
        
        
        try {
            start.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getIP(){
        try {
            return ss.getInetAddress().getLocalHost().toString();
        } catch (UnknownHostException ex) {
            System.err.println("Error at getIP: " + ex.toString());
        }
        return "Error";
    }
    
    public int getPORT(){
        try {
            return ss.getLocalPort();
        } catch (Exception ex) {
             System.err.println("Error at getPort: " + ex.toString());
        }
        return 0;
    }
    
    public void startGame(){
        joining.stop();
        
        try {
            voidSocket();
        } catch (IOException ex) {
            System.err.println("Error at closing joining: " + ex.toString());
        }
        this.gameStart = true;
        System.out.println("Game started");
        
        try {
            game(rounds);
        } catch (Exception ex) {
            System.err.println("Error at starting game " + ex.toString());
        }
    }
    
    private void endGame(){
        
    }
    
    private void game(int rounds) throws InterruptedException, SQLException{
        List<Question> list = DataSource.getInstance().getQuestionController().getEntities();
        
        for(int i = 0; i < rounds; ++i){
            
            //round start
            for(User p : players){
                p.sendStatus(1);
                System.out.println(p.getPlayerName() + " S1 "); 
           }
            
            Random random = new Random();
            int  n = random.nextInt(list.size());
            int questionID = list.get(n).getId().intValue();

            for(User p : players){
                p.sendQuestion(questionID);
            }
            ////////////////////////////
            Thread.sleep(timePerQuestion * 1000);
            ////////////////////////////
            
            //round end
            for(User p : players){
                p.sendStatus(2);
                try{
                    String answer = p.receiveAnswer();
                    if(answer.equals( list.get(n).getCorrectAnswer() ) ) /*question.answer*/{
                        p.addPoint();
                    }
                }catch(NoSuchElementException e){
                    
                }
                Thread.sleep(1000);
            }   
        }
        
        for(User p : players){
                p.sendStatus(3);
                p.sendPlayers(playersToString());
        }
        
    }
    
    private void startServer(){
        waitForClients(maxClients);
    }
    
    
    private void waitForClients(int maxClients){
        
        joining = new Thread( () -> {
            synchronized(players){
                while(players.size() < maxClients){
                    try{
                        
                        clientJoin();
                        System.out.println("Client connected: " + players.get(players.size()-1).getPlayerName());
                        
                        checkAlivePlayers();
                        
                        for(User p : players){
                            p.sendPlayers(playersToString());
                        }
                    }catch (Exception e){
                        System.err.println("Error at client connecting: " + e.toString());
                    };
                }
                
                System.out.println("Max players reached");
            }
        });
        
        try{
            joining.start();
        }catch(Exception e){
            System.err.println("Error at client joining: " + e.toString());
        }
        
    }
    
    private void clientJoin(){
        this.players.add(new User(ss));
    }
    
    private void voidSocket() throws IOException{
        Socket s = new Socket(ss.getInetAddress(), ss.getLocalPort());
    }
    
    public ArrayList<String> getPlayers(){
        ArrayList<String> result = new ArrayList<>(); 
        for(User p : players){
            result.add(p.getPlayerName());
        }
        
        return result;
    }
    
    public String playersToString(){
        String result = ""; 
        for(User p : players){
            result = result + p.getPlayerName() + ":" + p.getPoints() + ";";
        }
        
        return(result.substring(0, result.length() - 1));
    }
    
    private void checkAlivePlayers() throws IOException{
        for(User p : players){
            if(!p.isAlive() ){                               
                    System.out.println("Client disconnected: " + p.getPlayerName() );
                    players.remove(p);
                }
            }
    }
}
