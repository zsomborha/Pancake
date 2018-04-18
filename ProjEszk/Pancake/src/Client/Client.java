package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket s;
    private Scanner sc;
    private PrintWriter pw;
    
    private Scanner scIn;
    
    public Client(int PORT, String IP){
        try {
            s        = new Socket(IP, PORT);
            sc      = new Scanner(s.getInputStream(), "utf-8");
            pw  = new PrintWriter(s.getOutputStream());
            scIn    = new Scanner(System.in);
            
            System.out.println("Connected to server");
            Thread test = new Thread( () -> {
               while(true){
                   try{
                       Thread.sleep(100);
                   }catch(Exception e){
                       
                   }
               } 
            });
        }catch(Exception e ){
            
        }
    }
}
