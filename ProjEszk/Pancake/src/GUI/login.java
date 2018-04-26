/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Hartmann Zsombor
 */
public class login extends javax.swing.JFrame{

     void MakeServerPortMessage(String toString5) {
        JOptionPane.showMessageDialog(this, "A szerver az alabbi porton elindult: "+toString5);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sendUserMessage() {
        JOptionPane.showMessageDialog(this, "A nev mezo kitoltese kotelezo!");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        setSize(1130, 710);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameIcon.png")));
        
        // * LABEL * //
        
        jLabel7.setText("Üdvözlünk a Pancake Quiz játékban!");
        jLabel2.setText("Felhasználóneved: ");
        jLabel4.setText("IP címed: ");
        jLabel5.setText("PORT számod: ");
        jLabel6.setText("Első lépésként indítsd el a szervert!");
        
        Font font = new Font("Courier", Font.BOLD, 23);
        Font font2 = new Font("Courier", Font.BOLD, 27);
        jLabel2.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        jLabel6.setFont(font);
        jLabel7.setFont(font2);
        
        
        // * TEXTFIELD * //
        
        jTextField2.setText("IP...");
        jTextField3.setText("PORT...");
        jTextField1.setText("Név...");
        jTextField2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(jTextField2.getText().equals("IP...")){
                    jTextField2.setText("");
                }
            }
        });
        jTextField3.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               if(jTextField3.getText().equals("PORT...")){
                    jTextField3.setText("");
                }  
            }
        });
        jTextField1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(jTextField1.getText().equals("Név...")){
                    jTextField1.setText("");
                }
            }
        });
        
        jTextField1.setBackground(Color.decode("#F6F7AC"));
        jTextField2.setBackground(Color.decode("#F6F7AC"));
        jTextField3.setBackground(Color.decode("#F6F7AC"));
     
        
        // * BUTTON * //
        
        jButton1.setText("játékleírás");
        jButton2.setText("START");
        jButton3.setText("START SZERVER");
        
        jButton2.setBackground(Color.decode("#F45959"));
        jButton3.setBackground(Color.decode("#F45959"));
        
        jButton2.setForeground(Color.decode("#960505"));
        jButton3.setForeground(Color.decode("#960505"));
        
        Font font3 = new Font("Courier", Font.BOLD, 20);
        Font font4 = new Font("Courier", Font.BOLD, 12);
        jButton2.setFont(font3);
        jButton3.setFont(font4);
        
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bejelentkezés");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Üdvözlünk a Pancake Quiz játékban!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1227, 48, 174, 14);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(12, 1002, 73, 23);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 390, 260, 30);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(620, 390, 250, 30);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(500, 510, 190, 90);

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(620, 280, 250, 30);

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 170, 260, 30);

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(360, 280, 260, 30);

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(620, 170, 250, 30);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed1(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(30, 120, 150, 30);

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 70, 440, 40);

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(330, 20, 530, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/frameBackground.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1131, 707);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        modell.startGameDescrition();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       modell.startNewGame(jTextField1.getText().toString(), jTextField2.getText().toString(), jTextField3.getText().toString()); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed1
        // TODO add your handling code here:
        modell.startNewSzerver(jTextField3.getText().toString());
    }//GEN-LAST:event_jButton3ActionPerformed1

    /**
     * @param args the command line arguments
     */
    
    Modell modell;
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    void setModell(Modell aThis) {
        modell = aThis;
        System.out.println("setmodell");
    }

    void sendUserPortMessage() {
        JOptionPane.showMessageDialog(this, "A port mező kitöltése helytelen!");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void sendUserIpMessage() {
        JOptionPane.showMessageDialog(this, "Az IP mező kitöltése helytelen!");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void makeIllegalNumberForametMessage() {
        JOptionPane.showMessageDialog(this, "Nem megvalósítható portszám!");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
