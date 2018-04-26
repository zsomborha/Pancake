package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    static int playerNo = 0;
    private String name;
    private int points = 0;
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    
    public User(ServerSocket ss){
        try {
            this.s = ss.accept();
            this.sc = new Scanner(s.getInputStream());
            this.pw = new PrintWriter(s.getOutputStream());
            
        } catch (IOException ex) {
            System.err.println("Error at client connecting: " + ex.toString());
        }
        
        if(sc.hasNextLine()){
            this.name = sc.nextLine();
            pw.println("Welcome!");
            pw.flush();
        }else{
            ++playerNo;
            this.name = "User"+playerNo;
        }
    
    }
    
    public void sendQuestion( int questionID){
        if(!s.isClosed()){
            try {
                pw.println(questionID); // question = "Q123" 
                pw.flush();
            } catch (Exception e) {
                System.err.println("Error at sending question: " + e.toString());
            }  
        }
    }
    
    public void sendStatus(int status){ // endOfRound, endOfGame
        if(!s.isClosed()){
            try {
                pw.println("S" + status); // status = "S1"
                pw.flush();
            } catch (Exception e) {
                System.err.println("Error at sending statusChange: " + e.toString());
            }  
        }
    }
    
    public void sendPlayers(String players){ // endOfRound, endOfGame
        if(!s.isClosed()){
            try {
                pw.println("N");
                pw.flush();
                
                pw.println(players);
                pw.flush();
            } catch (Exception e) {
                System.err.println("Error at sending players: " + e.toString());
            }  
        }
    }
    
    public String receiveAnswer(){
        if(!s.isClosed()){
            try {
                String answer = sc.nextLine();
                System.out.println(getPlayerName() + " --> answer : " + answer);
                return answer;
            } catch (Exception e) {
                try {
                    s.close();
                } catch (IOException ex) {
                    System.err.println("Error at closing socket: " + ex.toString());
                }
                return "";
            }
        }
        return "";
    }
    
    public String getPlayerName(){
        return this.name;
    }
    
    public void addPoint(){
        ++this.points;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public boolean isAlive()throws IOException{
        try{
            pw.println("PING");
            pw.flush();
            sc.nextLine();
        }catch(Exception e){
            s.close();
            return false;
        }     
        return true;
    }
    
}
