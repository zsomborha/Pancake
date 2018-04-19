package Client;

import java.util.Scanner;

public class TestClient {
    
    static int PORT = 12345;
    static final String IP = "localhost";
    
    public static void main(String[] args) throws InterruptedException{
        
        Scanner scIN = new Scanner(System.in);    
        PORT = scIN.nextInt();
        
        for(int i = 0; i < 4; ++i){
            Thread.sleep(500);
            String name = "Dani"+i;
            Thread t1 = new Thread( () -> {
                Client c = new Client(PORT, IP, name);
            });
            t1.start();
        }
    }
    
}
