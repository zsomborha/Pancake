package Client;

import Client.Client;
import GameLogic.GameLogic;
import GameLogic.Player;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClient {
    
    public static int PORT = 12345;
    public static final String IP = "localhost";
    public static Client c;
    public static int status = 0;
    
    public static void main(String[] args) throws InterruptedException{
        
        Scanner scIN = new Scanner(System.in);    
        PORT = Integer.parseInt(scIN.nextLine() );
        String name = scIN.nextLine();
        GameLogic gl;
        try {
            gl = new GameLogic();
            c=new Client(PORT, IP, name, gl);
        } catch (Exception ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void statusZero(){
            //players changed
            ArrayList<Player> players = c.getPlayers();
        
            for(Player p : players){
                System.out.println("TEST: " + p.GetName() );
            }
    }
    
    public static void statusOne(){
            //new question, send answer
            Random rand = new Random();
            int answer = rand.nextInt(4);
            System.out.println("TEST: Answer =" + answer);
            c.setSelectedAnswer(answer);
        }
    
    public static void statusTwo(){    
            //end of question
        }
        
    public static void statusThree(){
            //end of game
            ArrayList<Player> players = c.getPlayers();
            
            for(Player p : c.players){
                System.out.println("TEST: " + p.GetName() + ": " + p.GetPoints());
            }
        }
    }
    
