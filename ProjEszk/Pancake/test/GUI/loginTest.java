/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class loginTest {
    
    public loginTest() {
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
     * Test of MakeServerPortMessage method, of class login.
     */
    @Test
    public void testMakeServerPortMessage() {
        System.out.println("MakeServerPortMessage");
        String toString5 = "hiba";
        login instance = new login();
        instance.MakeServerPortMessage(toString5);

    }

    /**
     * Test of sendUserMessage method, of class login.
     */
    @Test
    public void testSendUserMessage() {
        System.out.println("sendUserMessage");
        login instance = new login();
        instance.sendUserMessage();

    }

    /**
     * Test of main method, of class login.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        login.main(args);

    }

    /**
     * Test of setModell method, of class login.
     */
    @Test
    public void testSetModell() {
        System.out.println("setModell");
        Modell aThis = null;
        login instance = new login();
        instance.setModell(aThis);

    }

    /**
     * Test of sendUserPortMessage method, of class login.
     */
    @Test
    public void testSendUserPortMessage() {
        System.out.println("sendUserPortMessage");
        login instance = new login();
        instance.sendUserPortMessage();

    }

    /**
     * Test of sendUserIpMessage method, of class login.
     */
    @Test
    public void testSendUserIpMessage() throws Exception {
        System.out.println("sendUserIpMessage");
        login instance = new login();        
        instance.sendUserIpMessage();

    }

    /**
     * Test of makeIllegalNumberForametMessage method, of class login.
     */
    @Test
    public void testMakeIllegalNumberForametMessage() {
        System.out.println("makeIllegalNumberForametMessage");
        login instance = new login();
        instance.makeIllegalNumberForametMessage();

    }
    
}
