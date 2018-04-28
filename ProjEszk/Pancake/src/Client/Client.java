package Client;

import Client.TestClient.*;
import GameLogic.Player;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public ArrayList<Player> players = new ArrayList<>();
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private String msg = "";
    private Scanner scIn;
    private GameLogic.GameLogic gl;
    private int status = 0; //0-lobby 1-kérdés 2-kérdés vége 3-játék vége
    private int questionID;
    private String selectedAnswer = ""; //4-if not selected anything
    
    public Client(int PORT, String IP, String name,GameLogic.GameLogic gl){
        try {
            s        = new Socket(IP, PORT);
            sc      = new Scanner(s.getInputStream(), "utf-8");
            pw  = new PrintWriter(s.getOutputStream());
            scIn    = new Scanner(System.in);
            this.gl= gl;
            
            try{ 
                pw.println(name);
                pw.flush();
                
                Thread check = new Thread( () -> {
                    synchronized(msg){
                        try{
                        msg = sc.nextLine();
                        }catch(Exception e){}
                    }
                });
                    
                check.start();
                Thread.sleep(100);
                check.interrupt();
                
              if(msg.matches("Welcome!")){
                
                System.out.println("Connected to server");
                
                Thread receive = new Thread( () -> {
                synchronized(s){
                    receiveMSG();
                    System.out.println("Disconnected");
                }
                });
                
                receive.start();
                };//endif
                }catch(Exception e){
                    System.err.println("Error at connecting: " + e.toString());
                }
            
        }catch(Exception e ){
            System.err.println("Error at client: " + e.toString());
        }
    }
    
    private void receiveMSG(){
        while(!s.isClosed() && status < 3){
                    try{
                        String incomingMSG= "";
                        if(sc.hasNextLine()){
                            incomingMSG = sc.nextLine();
                        }
                        System.out.println("Client rec: " + incomingMSG);
                        if(!incomingMSG.equals("")){
                            if(incomingMSG.charAt(0) == 'N'){ //new Client
                                
                                String playersString = sc.nextLine();
                                
                                playersToArray(playersString);
                                
                                gl.statusZero();//status 0
                                //TestClient.statusZero();
                                
                            }else
                            if(incomingMSG.charAt(0) == 'S'){ //Status change
                                if(         incomingMSG.charAt(1) == '1'){//question ID  incoming
                                    this.status = 1;
                                    
                                   
                                    
                                    int questionID = Integer.parseInt(sc.nextLine());
                                    //TODO getQuestion(questionID)
                                    this.questionID = questionID;
                                    gl.statusOne();//status 1
                                    //TestClient.statusOne();
                                    
                                }else if(   incomingMSG.charAt(1) == '2'){//time is up, send answer
                                    this.status = 2;
                                    gl.statusTwo();//status 2
                                    //TestClient.statusTwo();
                                    
                                    pw.println(selectedAnswer);
                                    pw.flush();
                                    this.selectedAnswer = "";
                                    
                                }else if(   incomingMSG.charAt(1) == '3'){//game over 
                                    this.status = 3;

                                    sc.nextLine();
                                    String playersString = sc.nextLine();
                                    playersToArray(playersString);
                                    System.out.println("ok0");
                                    gl.statusThree();//status 3
                                   
                                    //TestClient.statusThree();
                                }
                            }else{
                                pw.println("PONG");
                                pw.flush();
                            }
                            }
                            //question ID
                        }catch(Exception e){
                            System.err.println("Error in client! : " + e.toString());
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
                    }

                }
    }
        
    public void setSelectedAnswer(String sa){
        this.selectedAnswer = sa;
    }
    
    public int getQuestionID(){
        return this.questionID;
    }
    
    public int getStatus(){
        return this.status;
    }
    
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    
    private ArrayList<Player> playersToArray(String input){
        this.players.clear();
        String[] temp = input.split(";");
        //ArrayList<Player> result = new ArrayList<Player>();
        
        for(int i = 0; i < temp.length; ++i){
            String[] p = temp[i].split(":");
            players.add(new Player(p[0]) );
            players.get(i).setPoints( Integer.parseInt(p[1]) );
        }
        
        System.out.println("a tomb merete:"+this.players.size());
        return(players);
    }
    
}
