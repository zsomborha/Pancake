package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private ServerSocket ss;
    private int rounds;
    private final int maxClients = 4;
    private boolean gameStart = false;
    private ArrayList<Player> players = new ArrayList<Player>();
    
    public Server(int rounds){
        this.rounds = rounds;
        try {
            ss = new ServerSocket(12345);
        } catch (IOException ex) {
            System.err.println("Error at creating server: " + ex.toString());
        }
        
        Thread start = new Thread( () -> {startServer();} );
        start.start();
        
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
        this.gameStart = true;
    }
    
    private void endGame(){
        
    }
    
    private void startServer(){
        waitForClients(maxClients);
    }
    
    
    private void waitForClients(int maxClients){
        
        Thread joining = new Thread( () -> {
            while(players.size() <= maxClients){
                clientJoin();
                System.out.println("Client connected " + players.size());
            }
        });
        
        Thread waiting = new Thread( () -> {
            while(!gameStart){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.err.println("Error at client joining: " + ex.toString());
                }
            }
            System.out.println("Client connected");
            joining.stop();
        });
        try{
            joining.start();
            waiting.start();
               
            
        }catch(Exception e){
            System.err.println("Error at client joining: " + e.toString());
        }
        
    }
    
    private void clientJoin(){
        this.players.add(new Player(ss));
    }
}
