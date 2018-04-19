package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Player {
    static int playerNo = 0;
    private String name;
    private int points;
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    
    public Player(ServerSocket ss){
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
            this.name = "Player"+playerNo;
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
    
    public void sendPoints(String points){ // endOfRound, endOfGame
        if(!s.isClosed()){
            try {
                pw.println(points); // status = "S1"
                pw.flush();
            } catch (Exception e) {
                System.err.println("Error at sending pointse: " + e.toString());
            }  
        }
    }
    
    public int receiveAnswer(){
        if(!s.isClosed()){
            try {
                int answer = Integer.parseInt(sc.nextLine());
                return answer;
            } catch (Exception e) {
                System.err.println("Error at receiving answer: " + e.toString());
                return 0;
            }
        }
        return 0;
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
    
}
