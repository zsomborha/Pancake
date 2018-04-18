
package Server;

import Client.Client;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRun {
     public static void main(String[] args) throws Exception {

            Thread createServer = new Thread( () -> {
                Server server = new Server(5);
                String IP = server.getIP();
                System.out.println(IP);
                int PORT = server.getPORT();
                System.out.println(PORT);
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestRun.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                server.startGame();
            });
            
            createServer.start();
            System.out.println("asd");
            
            int PORT = 12345;
            
            Client c1 = new Client(PORT , "localhost");
            Client c2 = new Client(PORT , "localhost");
            Client c3 = new Client(PORT , "localhost");
            Client c4 = new Client(PORT , "localhost");
            Client c5 = new Client(PORT , "localhost");
            
            
    }
}
