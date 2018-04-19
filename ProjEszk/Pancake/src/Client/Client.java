package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private String msg = "";
    private Scanner scIn;
    private int status = 0; //0-lobby 1-kérdés 2-kérdés vége 3-játék vége
    
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
                            String incomingMSG= "0";
                            if(sc.hasNextLine()){
                                incomingMSG = sc.nextLine();
                            }
                            if(!incomingMSG.equals("")){
                                System.out.println(incomingMSG);
                            
                            
                            //status mod
                            if(incomingMSG.charAt(0) == 'S'){
                                if(         incomingMSG.charAt(1) == '1'){//question ID  incoming
                                    int questionID = sc.nextInt();
                                    //getQuestion(questionID)
                                    status = 0;
                                    System.out.println("QID: " +questionID );
                                    
                                }else if(   incomingMSG.charAt(1) == '2'){//time is up, send answer
                                    
                                    //getSelectedAnswer()
                                    //if(selectedAnswer() != 0)
                                    status = 2;
                                    pw.println("100");
                                    pw.flush();
                                    
                                }else if(   incomingMSG.charAt(1) == '3'){//game over
                                    status = 3;
                                    String points = sc.nextLine();
                                    System.out.println(points);
                                    
                                }
                            }
                            }
                            //question ID
                        }catch(Exception e){
                            System.out.println("Disconnected " + e.toString());
                    }
                }
    }
    
    
}
