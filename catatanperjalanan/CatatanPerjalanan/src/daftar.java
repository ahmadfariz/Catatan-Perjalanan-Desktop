
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crYptONE
 */
public class daftar extends javax.swing.JFrame {

    /**
     * Creates new form daftar
     */
    public daftar() {
        initComponents();
        tabel.setModel(tblModel);
        Tabel(tabel, new int[]{100,180,200,300,150,150,100});
        setDefaultTable();
        
//        nika.setEnabled(false);
//        nmpengguna.setEnabled(false);
//        alpengguna.setEnabled(false);
//        jenkel.setEnabled(false);
//        tambah.setEnabled(true);
//        simpan.setEnabled(false);
//        ubah.setEnabled(false);
//        hapus.setEnabled(false);
//        keluar.setEnabled(true);
//        batal.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setSize(1010,530);
    }
            
    private void hub(String sql){
        try {
            String hubung="jdbc:mysql://localhost:3306/perjalanan_catatan";
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
                new String []{"id_pengguna","nik","nama_pengguna","alamat_pengguna","jenis_kelamin"}
        ){
        boolean[] canEdit = new boolean []{
            false,false,false
        };
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit [columnIndex];
        }
        };
                }
        
        String data[]=new String[4];
            public void setDefaultTable() {
        try{
            String hubung = "jdbc:mysql://localhost:3306/perjalanan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String SQL = "Select * FROM tb_pengguna order by nik asc";
            ResultSet res = stt.executeQuery(SQL);
            tblModel.setRowCount(0);
        while(res.next()){
            data[0] = res.getString(1);
            data[1] = res.getString(2);
            data[2] = res.getString(3);  
            data[3] = res.getString(4);
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nmpengguna = new javax.swing.JTextField();
        alpengguna = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        nika = new javax.swing.JTextField();
        idpengguna = new javax.swing.JTextField();
        jenkel = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        bg = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        setSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

        nmpengguna.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nmpengguna.setBorder(null);
        getContentPane().add(nmpengguna);
        nmpengguna.setBounds(190, 100, 230, 40);

        alpengguna.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        alpengguna.setBorder(null);
        alpengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alpenggunaActionPerformed(evt);
            }
        });
        getContentPane().add(alpengguna);
        alpengguna.setBounds(190, 150, 230, 150);

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(750, 30, 190, 40);

        nika.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nika.setBorder(null);
        getContentPane().add(nika);
        nika.setBounds(190, 50, 230, 40);
        getContentPane().add(idpengguna);
        idpengguna.setBounds(480, 30, 210, 40);

        jenkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis Kelamin", "Laki - Laki", "Perempuan" }));
        getContentPane().add(jenkel);
        jenkel.setBounds(250, 330, 170, 25);

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
        jScrollPane1.setBounds(450, 80, 540, 320);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(0, 0, 1000, 500);
        getContentPane().add(cari);
        cari.setBounds(940, 20, 50, 60);

        tambah.setText("jButton1");
        getContentPane().add(tambah);
        tambah.setBounds(30, 430, 100, 60);

        simpan.setText("jButton1");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan);
        simpan.setBounds(150, 430, 100, 60);

        hapus.setText("jButton1");
        getContentPane().add(hapus);
        hapus.setBounds(270, 430, 100, 60);

        ubah.setText("jButton1");
        getContentPane().add(ubah);
        ubah.setBounds(390, 430, 100, 60);

        batal.setText("jButton1");
        getContentPane().add(batal);
        batal.setBounds(510, 430, 100, 60);

        keluar.setText("jButton1");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar);
        keluar.setBounds(630, 430, 100, 60);

        setBounds(0, 0, 1015, 536);
    }// </editor-fold>//GEN-END:initComponents

    private void alpenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alpenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alpenggunaActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        try {
            String sql="insert into tb_pengguna values('"+nika.getText()+"','"+nmpengguna.getText()+"','"+alpengguna.getText()+"','"+jenkel.getSelectedItem()+"')";
            hub(sql);
            setDefaultTable();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!");
        }
    }//GEN-LAST:event_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftar().setVisible(true);
            }
        });
    }
    
    public void Kode(){        
        try{
            String hubung = "jdbc:mysql://localhost:3306/perjalanan_catatan";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stmt = kon.createStatement();
            String SQL = "select max(right(tb_pengguna,2)) as NO from tb_pengguna";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                if(rs.first() == false)
                {
                    idpengguna.setText("IM0");
                }
                else
                {
                   rs.last();
                   int auto = rs.getInt(1) + 1;
                   String NO = String.valueOf(auto);
                   int noLong = NO.length();
                   for(int a=0;a<2-noLong;a++)
                    { 
                        NO = "IM0" + NO;
                    }
                   idpengguna.setText(NO);
                
                 }        
            }
            rs.close();
            stmt.close();
            }    
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                            "Kesalahan", JOptionPane.WARNING_MESSAGE);

        }
    }
    
        int row = 0;
    public void Tampil(){
        row = tabel.getSelectedRow();
        idpengguna.setText(tblModel.getValueAt(row,0).toString());
        nmpengguna.setText(tblModel.getValueAt(row,1).toString());
        alpengguna.setText(tblModel.getValueAt(row,2).toString());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alpengguna;
    private javax.swing.JButton batal;
    private javax.swing.JLabel bg;
    private javax.swing.JButton cari;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField idpengguna;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> jenkel;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nika;
    private javax.swing.JTextField nmpengguna;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}