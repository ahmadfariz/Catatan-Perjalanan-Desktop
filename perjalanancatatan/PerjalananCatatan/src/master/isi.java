package master;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.*;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author crYptONE
 * @param userName
 * @param userRole
 */
public class isi extends javax.swing.JFrame {
    public static int kodepengguna;
    Connection koneksi;
    ResultSet resultSet;
    Statement statement;

    /**
     * Creates new form isi
     * @param userName
     * @param userRole
     */
    public isi() {
        initComponents();
        tglskrg();
        setDefaultTable();
        this.setLocationRelativeTo(null);
        
        try {
            String hubung="jdbc:mysql://localhost:3306/jalan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon=DriverManager.getConnection(hubung,"root","");
            java.sql.Statement stt=kon.createStatement();
            String SQL= "select * from tb_pengguna";
            ResultSet res=stt.executeQuery(SQL);
            while (res.next()) {
                nik.setText(res.getString(1));
                nama.setText(res.getString(2));
            }

        } catch(Exception exc){
            System.err.printf(exc.getMessage());
        }
        
    }

    
        private void hub(String sql){
        try {
            String hubung="jdbc:mysql://localhost:3306/jalan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon=DriverManager.getConnection(hubung,"root","");
            java.sql.Statement stt=kon.createStatement();
            stt.executeUpdate(sql);
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
        
    }
        
            String data[]=new String[5];
    public void setDefaultTable() {
        try{
            String hubung = "jdbc:mysql://localhost:3306/jalan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            java.sql.Statement stt = kon.createStatement();
            String SQL = "select * from tb_pengguna";
            ResultSet res = stt.executeQuery(SQL);
        while(res.next()){
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);
            data[3] = res.getString(4);
            data[4] = res.getString(5);
        }
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
        }
    }
    
    public void tglskrg(){
        java.util.Date skrg= new java.util.Date();
        SimpleDateFormat format= new SimpleDateFormat("dd MMMM yyyy");
        String tgl = format.format(skrg);
        txttgl.setText(format.format(skrg));
        txttgl.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        txttgl = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        nika = new javax.swing.JComboBox<>();
        nik = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(885, 560));
        setPreferredSize(new java.awt.Dimension(885, 560));
        setSize(new java.awt.Dimension(885, 560));
        getContentPane().setLayout(null);

        jTextField1.setText("\n");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(600, 240, 230, 50);
        getContentPane().add(txttgl);
        txttgl.setBounds(590, 80, 260, 50);

        jTextField4.setText("\n");
        getContentPane().add(jTextField4);
        jTextField4.setBounds(600, 180, 230, 50);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(760, 380, 90, 40);

        getContentPane().add(nika);
        nika.setBounds(60, 340, 180, 70);
        getContentPane().add(nik);
        nik.setBounds(40, 70, 140, 60);
        getContentPane().add(nama);
        nama.setBounds(40, 160, 160, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 560);

        setBounds(0, 0, 896, 599);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(isi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new isi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nik;
    private javax.swing.JComboBox<String> nika;
    private javax.swing.JTextField txttgl;
    // End of variables declaration//GEN-END:variables
}