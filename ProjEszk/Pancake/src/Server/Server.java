package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private ServerSocket ss;
    private int rounds;
    private final int maxClients = 4;
    private boolean gameStart = false;
    private Thread joining;
    public ArrayList<Player> players = new ArrayList<Player>();
    
    public Server(int rounds){
        this.rounds = rounds;
        try {
            ss = new ServerSocket(0);
        } catch (IOException ex) {
            System.err.println("Error at creating server: " + ex.toString());
        }
         
        startServer();
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
        joining.interrupt();
        try {
            voidSocket();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gameStart = true;
        System.out.println("Game started");
        
        try {
            game(rounds);
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void endGame(){
        
    }
    
    private void game(int rounds) throws InterruptedException{
        for(int i = 0; i < rounds; ++i){
            
            //round start
            for(Player p : players){
                p.sendStatus(1);
                System.out.println(p.getPlayerName() + " S1 "); 
           }
            
            Random random = new Random();
            int  n = random.nextInt(50) + 1;
            int questionID = n;
            
            for(Player p : players){
                p.sendQuestion(questionID);
            }
            ////////////////////////////
            Thread.sleep(2000);
            ////////////////////////////
            //round end
            for(Player p : players){
                p.sendStatus(2);
                int answer = p.receiveAnswer();
                
                System.out.println(p.getPlayerName() + " : " + answer);
                
                Thread.sleep(100);
                
                if(answer == 100 /*question.answer*/ ){
                    p.addPoint();
                }
            }   
        }
        
        String points = "";
        for(Player p : players){
            points = points + " ; " + p.getPlayerName() + " : " + p.getPoints();
        }
        
        for(Player p : players){
                p.sendStatus(3);
                Thread.sleep(100);
                p.sendPoints(points);
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
                    }catch (Exception e){
                        System.err.println("Error at client connecting: " + e.toString());
                    };
                }
                System.out.println("Max players reached");
                
                try {
                    game(rounds);
                } catch (InterruptedException ex) {
                    
                }
            }
        });
        
        try{
            joining.start();
            
        }catch(Exception e){
            System.err.println("Error at client joining: " + e.toString());
        }
        
    }
    
    private void clientJoin(){
        this.players.add(new Player(ss));
    }
    
    private void voidSocket() throws IOException{
        Socket s = new Socket(ss.getInetAddress(), ss.getLocalPort());
    }
    
    public ArrayList<String> getPlayers(){
        ArrayList<String> result = new ArrayList<>(); 
        for(Player p : players){
            result.add(p.getPlayerName());
        }
        
        return result;
    }
}
