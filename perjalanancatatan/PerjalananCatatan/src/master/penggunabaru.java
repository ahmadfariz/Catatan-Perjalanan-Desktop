/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author crYptONE
 */
public class penggunabaru extends javax.swing.JFrame {

    /**
     * Creates new form penggunabaru
     */
    public penggunabaru() {
        initComponents();
        tabel.setModel(tblModel);
        setDefaultTable();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nik = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        jenkel = new javax.swing.JComboBox<>();
        simpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        pengguna = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        setSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);
        getContentPane().add(nik);
        nik.setBounds(190, 50, 210, 40);
        getContentPane().add(nama);
        nama.setBounds(190, 100, 210, 40);
        getContentPane().add(alamat);
        alamat.setBounds(190, 150, 210, 40);

        jenkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis Kelamin", "Laki - Laki", "Perempuan" }));
        getContentPane().add(jenkel);
        jenkel.setBounds(240, 320, 180, 50);

        simpan.setText("jButton1");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan);
        simpan.setBounds(150, 430, 100, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 500);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(480, 80, 453, 320);

        pengguna.setText("Pengguna");
        getContentPane().add(pengguna);
        pengguna.setBounds(470, 40, 150, 40);

        setBounds(0, 0, 1016, 539);
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        try{
            String SQL = "insert into tb_pengguna values('"+nik.getText()+"','"+nama.getText()+"','"+alamat.getText()+"','"+jenkel.getSelectedItem()+"','"+pengguna.getText()+"')";
            hub(SQL);
            setDefaultTable();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
        }catch(Exception exc){
            System.err.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!");
        }
    }//GEN-LAST:event_simpanActionPerformed

        private void hub(String sql){
        try {
            String hubung="jdbc:mysql://localhost:3306/jalan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon=DriverManager.getConnection(hubung,"root","");
            Statement stt=kon.createStatement();
            stt.executeUpdate(sql);
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
        
    }
        
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
    
    private void Tabel(javax.swing.JTable tb, int lebar[]) {
        tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int kolom=tb.getColumnCount();
        for(int i=0;i<kolom;i++) {
            javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
            tb.setRowHeight(17);
        }
    }
    
        private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object [][]{},
                new String []{"NIK","NAMA","ALAMAT","JENKEL"}
        ){
        boolean[] canEdit = new boolean []{
            false,false,false
        };
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }
        };
                }
        
        String data[]=new String[5];
    public void setDefaultTable() {
        try{
            String hubung = "jdbc:mysql://localhost:3306/jalan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String SQL = "select * from tb_pengguna";
            ResultSet res = stt.executeQuery(SQL);
            tblModel.setRowCount(0);
        while(res.next()){
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);
            data[3] = res.getString(4);
            data[4] = res.getString(5);
            tblModel.addRow(data);
        }
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
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
            java.util.logging.Logger.getLogger(penggunabaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penggunabaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penggunabaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penggunabaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penggunabaru().setVisible(true);
            }
        });
    }
    
    public void Kode(){        
        try{
            String hubung = "jdbc:mysql://localhost:3306/jalan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stmt = kon.createStatement();
            }    
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenkel;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nik;
    private javax.swing.JLabel pengguna;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
