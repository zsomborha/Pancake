package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Player {
    static int playerNo = 0;
    private String name;
    private int score;
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
        }else{
            ++playerNo;
            this.name = "Player"+playerNo;
        }
    
    }
    
    public void sendQuestion( String question){
        if(!s.isClosed()){
            try {
                pw.println(question);
            } catch (Exception e) {
                System.err.println("Error at sending question: " + e.toString());
            }  
        }
    }
    
    public void statusChange(String status){ // endOfRound, endOfGame
        if(!s.isClosed()){
            try {
                pw.println(status);
            } catch (Exception e) {
                System.err.println("Error at sending statusChange: " + e.toString());
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
    
}
