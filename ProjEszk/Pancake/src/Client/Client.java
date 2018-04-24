package Client;

import GameLogic.Player;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public ArrayList<Player> players = new ArrayList<>();
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private String msg = "";
    private Scanner scIn;
    private int status = 0; //0-lobby 1-kérdés 2-kérdés vége 3-játék vége
    private int questionID;
    private int selectedAnswer = 4; //4-if not selected anything
    
    public Client(int PORT, String IP, String name){
        try {
            s        = new Socket(IP, PORT);
            sc      = new Scanner(s.getInputStream(), "utf-8");
            pw  = new PrintWriter(s.getOutputStream());
            scIn    = new Scanner(System.in);
            
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
                            
                        if(!incomingMSG.equals("")){
                            if(incomingMSG.charAt(0) == 'N'){ //new Client
                                String playersString = sc.nextLine();
                                
                                playersToArray(playersString);
                                
                                //GameLogic.GameLogic.statusZero();//status 0
                                TestClient.statusZero();
                                
                            }else
                            if(incomingMSG.charAt(0) == 'S'){ //Status change
                                if(         incomingMSG.charAt(1) == '1'){//question ID  incoming
                                    this.status = 1;
                                    //GameLogic.GameLogic.statusOne();//status 1
                                    TestClient.statusOne();
                                    
                                    int questionID = sc.nextInt();
                                    //TODO getQuestion(questionID)
                                    this.questionID = questionID;
                                    
                                }else if(   incomingMSG.charAt(1) == '2'){//time is up, send answer
                                    
                                    this.status = 2;
                                    //GameLogic.GameLogic.statusTwo();//status 2
                                    TestClient.statusTwo();
                                    
                                    pw.println(selectedAnswer);
                                    pw.flush();
                                    this.selectedAnswer = 4;
                                    
                                }else if(   incomingMSG.charAt(1) == '3'){//game over
                                    
                                    this.status = 3;
                                    
                                    
                                    
                                    sc.nextLine();
                                    String playersString = sc.nextLine();
                                    playersToArray(playersString);
                                    
                                    //GameLogic.GameLogic.statusThree();//status 3
                                    TestClient.statusThree();
                                }
                            }
                            }
                            //question ID
                        }catch(Exception e){
                            System.err.println("Error in client! : " + e.toString());
                    }
                }
    }
        
    public void setSelectedAnswer(int sa){
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
        
        return(players);
    }
    
}
