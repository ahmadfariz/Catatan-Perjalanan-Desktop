
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crYptONE
 */
public class login extends javax.swing.JFrame {
    public Connection con;
    public Statement stt;
    public ResultSet rs;
    public static int kondisipengguna;
    public static String userLogin="tidak terdeteksi";

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        background = new javax.swing.JLabel();
        masuk = new javax.swing.JButton();
        daftar = new javax.swing.JButton();
        exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(824, 534));
        setSize(new java.awt.Dimension(824, 534));
        getContentPane().setLayout(null);

        nama.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 0, 0));
        nama.setToolTipText("");
        nama.setBorder(null);
        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namaKeyTyped(evt);
            }
        });
        getContentPane().add(nama);
        nama.setBounds(170, 300, 490, 70);

        nik.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        nik.setForeground(new java.awt.Color(0, 0, 0));
        nik.setBorder(null);
        nik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nikKeyTyped(evt);
            }
        });
        getContentPane().add(nik);
        nik.setBounds(170, 170, 490, 70);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 820, 530);

        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        getContentPane().add(masuk);
        masuk.setBounds(460, 400, 220, 60);

        daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
            }
        });
        getContentPane().add(daftar);
        daftar.setBounds(160, 400, 280, 60);

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(750, 10, 60, 50);

        setBounds(0, 0, 821, 532);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
        // TODO add your handling code here:
        try{
            // Statement stt = (Statement)Koneksi.GetConnection().createStatement();
            koneksi();
            ResultSet result = stt.executeQuery("SELECT * FROM tb_pengguna WHERE nik = '"+ nik.getText() +"'"
                + "AND nama = '" + nama.getText() + "'");
            if(result.next()){
                //new Dashbord();
                new menu(result.getString(1), result.getString(2)).setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Data tidak valid. Silahkan isi data anda dengan benar");
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(rootPane, "Login gagal.");
        }
    }//GEN-LAST:event_masukActionPerformed

    private void namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyTyped
        // TODO add your handling code here:
        if (nama.getText().length() == 25 ) { //filter batas
            evt.consume();
        }
    }//GEN-LAST:event_namaKeyTyped

    private void nikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nikKeyTyped
        // TODO add your handling code here:
        if (nik.getText().length() == 11 ) { //filter batas
            evt.consume();
            JOptionPane.showMessageDialog(null, "Batas Karakater 11");
        }
        filterhuruf(evt);
    }//GEN-LAST:event_nikKeyTyped

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarActionPerformed
        // TODO add your handling code here:
        new daftar().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_daftarActionPerformed

    //addfilter
    void filterhuruf (KeyEvent a) {
        if(Character.isAlphabetic(a.getKeyChar())) {
            a.consume();
        JOptionPane.showMessageDialog(null, "Hanya Di Isi Angka");
        }
    }
    
    void filterangka (KeyEvent b) {
        if(Character.isDigit(b.getKeyChar())) {
            b.consume();
        JOptionPane.showMessageDialog(null, "Hanya Di Isi Huruf");
        }
    }
    
    //database
    private void koneksi() {
        try {
            String hubung="jdbc:mysql://localhost:3306/perjalanan_catatan";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(hubung,"root","");
            stt=con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_UPDATABLE);
            rs=stt.executeQuery("select * FROM tb_pengguna");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }
    
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
    private javax.swing.JLabel background;
    private javax.swing.JButton daftar;
    private javax.swing.JLabel exit;
    private javax.swing.JButton masuk;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nik;
    // End of variables declaration//GEN-END:variables
}
