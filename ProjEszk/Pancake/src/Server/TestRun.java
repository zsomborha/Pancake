
package Server;

import Client.Client;
import Client.TestClient;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRun {
     public static void main(String[] args) throws Exception {

            Thread createServer = new Thread( () -> {
                Server server = new Server(0,10,1);
                Scanner scIN = new Scanner(System.in);
                String IP = server.getIP();
                System.out.println(IP);
                int PORT = server.getPORT();
                System.out.println(PORT);
                
                try {

                    scIN.nextLine();
                    server.startGame();
                    
                } catch (Exception ex) {
                    System.out.println("asdasd");
                }
                
                //server.startGame();
                
                
               /* for(String name : server.getPlayers()){
                    System.out.println(name) ;
                }*/
                
            });
            
            createServer.start();
            
            createServer.join();
                    
    }
}
