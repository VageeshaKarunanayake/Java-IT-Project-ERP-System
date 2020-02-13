/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Thushan
 */
public class report extends javax.swing.JFrame {

    /**
     * Creates new form report
     */
    public report() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        From_Date = new org.jdesktop.swingx.JXDatePicker();
        From_Date.setSize(194, 200);
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        To_Date = new org.jdesktop.swingx.JXDatePicker();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 90)); // NOI18N
        jLabel2.setText("Report");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(490, 40, 470, 110);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setText("Total Number Of Outgoing");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 480, 430, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel6.setText("Total Number Of Incoming");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 400, 430, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton1.setText("Back to Main");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(980, 660, 150, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton2.setText("Genarate");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(780, 650, 130, 50);

        From_Date.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        From_Date.setPreferredSize(new java.awt.Dimension(144, 40));
        getContentPane().add(From_Date);
        From_Date.setBounds(760, 210, 310, 40);

        jLabel10.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jLabel10.setText(":-");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(520, 220, 15, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel8.setText("From");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(190, 209, 180, 50);

        To_Date.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        getContentPane().add(To_Date);
        To_Date.setBounds(760, 300, 310, 38);

        jLabel11.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jLabel11.setText(":-");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(520, 300, 50, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel9.setText("To");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(190, 300, 110, 39);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Please select the date");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(770, 490, 310, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // back-main
        main m = new main();
        m.setSize(1500,1000);
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        java.util.Date minDate = From_Date.getDate();        
        java.util.Date maxDate = To_Date.getDate();
   try{
             
            Connection conn = DatabaseConnection.connect();
             PreparedStatement DBOUT = conn.prepareStatement("SELECT * FROM orders WHERE strftime('%s', orderDate) BETWEEN strftime('%s', ?) AND strftime('%s', ? )");
            
         
            java.sql.Date d1= new java.sql.Date(minDate.getTime());
            DBOUT.setDate(1,d1);
            
            java.sql.Date d2 = new java.sql.Date(maxDate.getTime());
            DBOUT.setDate(2,d2);
            
            ResultSet RS = DBOUT.executeQuery();
           int count = 0;
            int total = 0;
            
         while(RS.next()){
                count++;
                total = total + RS.getInt("quantity");
                
                }
                
       
         
         jLabel1.setText(Integer.toString(total));
        
         }catch(Exception e){
             System.out.println(e);
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new report().setVisible(true);
                report re = new report();
                re.setSize(1300,850);
                re.setResizable(false);
                re.setVisible(true);
                re.setLocationRelativeTo(null);
                
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker From_Date;
    private org.jdesktop.swingx.JXDatePicker To_Date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
