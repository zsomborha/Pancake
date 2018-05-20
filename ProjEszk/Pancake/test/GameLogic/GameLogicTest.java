/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import GUI.Modell;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hartmann Zsombor
 */
public class GameLogicTest {
    
    public GameLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of statusChange method, of class GameLogic.
     */
    @Test
    public void testStatusChange() {
        System.out.println("statusChange");
        int status = 0;
        GameLogic.statusChange(status);

    }

    /**
     * Test of statusZero method, of class GameLogic.
     */
    @Test
    public void testStatusZero() throws Exception {
        System.out.println("statusZero");
        GameLogic instance = new GameLogic(false);
        instance.statusZero();

    }

    /**
     * Test of statusOne method, of class GameLogic.
     */
    @Test
    public void testStatusOne() {
        System.out.println("statusOne");
        GameLogic instance = null;
        try{
            instance.statusOne();
        }
        catch (NullPointerException e){
            System.err.println("");
        }

    }

    /**
     * Test of statusTwo method, of class GameLogic.
     */
    @Test
    public void testStatusTwo() throws Exception {
        System.out.println("statusTwo");
        GameLogic instance = new GameLogic(false);
        try{
            instance.statusTwo();
        }catch(NullPointerException e){
            System.err.println("");
        }
        

    }

    /**
     * Test of statusThree method, of class GameLogic.
     */
    @Test
    public void testStatusThree() {
        System.out.println("statusThree");
        GameLogic instance = null;
        try{
            instance.statusThree();
        }catch(Exception e){
            System.err.println("");
        }
        

    }

    /**
     * Test of startCommunication method, of class GameLogic.
     */
    @Test
    public void testStartCommunication() {
        System.out.println("startCommunication");
        String playerName = "";
        String ip = "";
        String port = "";
        GameLogic instance = null;
        try{
            instance.startCommunication(playerName, ip, port);
        }catch(Exception e){
            System.err.println("");
        }
        

    }

    /**
     * Test of getQuestion method, of class GameLogic.
     */
    @Test
    public void testGetQuestion() throws Exception {
        System.out.println("getQuestion");
        GameLogic instance = null;
        String[] expResult = null;
        try{
           String[] result = instance.getQuestion(); 
        }catch(Exception e){
            System.err.println("");
        }

    }

    /**
     * Test of sendAnswer method, of class GameLogic.
     */
    @Test
    public void testSendAnswer() {
        System.out.println("sendAnswer");
        String answer = "";
        GameLogic instance = null;
        try{
           instance.sendAnswer(answer); 
        }catch(NullPointerException e){
            System.err.println("");
        }
        

    }

    /**
     * Test of getResult method, of class GameLogic.
     */
    @Test
    public void testGetResult() {
        
        
        
        System.out.println("getResult");
       
        try{
            GameLogic instance = new GameLogic(false);
            ArrayList expResult = null;
            ArrayList result = instance.getResult();
        }catch(NullPointerException e){
            System.out.println("Error: no client!");
        } catch (Exception ex) {
            Logger.getLogger(GameLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of startSzerver method, of class GameLogic.
     */
    @Test
    public void testStartSzerver() throws Exception {
        System.out.println("startSzerver");
        int parseInt = 12345;
        GameLogic instance = new GameLogic(false);
        instance.startSzerver(parseInt);

    }

    /**
     * Test of startGame method, of class GameLogic.
     */
    
    @Test
    public void testStartGame() {
        System.out.println("startGame");
        try{
            GameLogic.startGame();
        }catch (NullPointerException e){
            if(e.getMessage().equals("No server!")){
                System.out.println("Passed");
            }else{
                System.err.println("Error");
            }
        }
        
    }
    
}
