/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DAO.HoaDonDAO;
import DAO.PhieuKhamBenhDAO;
import connect.MyConnect;
import helper.ShareHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.HoaDonVienPhi;
import model.phieuKhamBenh;


/**
 *
 * @author Quang
 */
public class Frm_qlPhieuKhamBenh extends javax.swing.JFrame {
    ArrayList<phieuKhamBenh> list = new ArrayList<>();
    int current = 0;
private final Date today = new Date();
    Locale local = new Locale("vi", "VI");
    DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
    String date = d.format(today);
    /**
     * Creates new form frm_qlUser
     */
    public Frm_qlPhieuKhamBenh() {
        initComponents();
        
        txtDate.setEnabled(false);
        comboBox();
        txtDate.setText(date);
        load();
    }
    public void comboBox(){
        cboMaHS.addItem("BA001");
        cboMaHS.addItem("BA002");
        cboMaHS.addItem("BA003");
        cboMaHS.addItem("BA004");
        cboBacsi.addItem("BS001");
        cboBacsi.addItem("BS002");
        cboBacsi.addItem("BS003");
        cboBacsi.addItem("BS004");
    }
    public void load(){
        try {
             
            Connection cn = new MyConnect().getcn();
            PreparedStatement ps = cn.prepareStatement("select * from PhieuKhamBenh");
             ResultSet rs = ps.executeQuery();
            list.clear();// xoá list để lấy dữ liệu từ bảng
            while(rs.next()){
                phieuKhamBenh pkb = new phieuKhamBenh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(pkb);
            }
            cn.close();
            ps.close();
            DefaultTableModel model = (DefaultTableModel) tbl_table.getModel();
        model.setRowCount(0);
        for(phieuKhamBenh pkb : list){
            Object[] row = new Object[]{pkb.getSoPhieuKhamBenh(),pkb.getMaHoSo(),pkb.getMaBacSi(),pkb.getTenBenh(),pkb.getNgayKhamBenh()};
            model.addRow(row);
        }
        } catch (Exception e) {
        }
    }
    public void show_Detail(){
        // lấy ra sv hiện hành
        phieuKhamBenh pkb = list.get(current);
        // gán thông tin sv lên form
        txtSoPhieuKhamBenh.setText(pkb.getSoPhieuKhamBenh());
        txtTenBenh.setText(pkb.getTenBenh());
        txtDate.setText(pkb.getNgayKhamBenh());
        cboMaHS.setSelectedItem(pkb.getMaHoSo());
        cboBacsi.setSelectedItem(pkb.getMaBacSi());
       
    }
    public void insert(){
        try {
            phieuKhamBenh pkb = new phieuKhamBenh();
            pkb.setSoPhieuKhamBenh(txtSoPhieuKhamBenh.getText());
            pkb.setMaHoSo(cboMaHS.getSelectedItem().toString());
            pkb.setMaBacSi(cboBacsi.getSelectedItem().toString());
            pkb.setTenBenh(txtTenBenh.getText());
            pkb.setNgayKhamBenh(txtDate.getText());
            PhieuKhamBenhDAO dao = new PhieuKhamBenhDAO();
            int kq = dao.insert(pkb);
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại.");
            }

            //4. nhớ gọi lại load_data() để load dữ liệu mới lên jtable
            load();
        } catch (Exception e) {
        }
    }
    public void update(){
        try {
            phieuKhamBenh pkb = new phieuKhamBenh();
            pkb.setSoPhieuKhamBenh(txtSoPhieuKhamBenh.getText());
            pkb.setMaHoSo(cboMaHS.getSelectedItem().toString());
            pkb.setMaBacSi(cboBacsi.getSelectedItem().toString());
            pkb.setTenBenh(txtTenBenh.getText());
            pkb.setNgayKhamBenh(txtDate.getText());
            PhieuKhamBenhDAO dao = new PhieuKhamBenhDAO();
            int kq = dao.update(pkb);
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại.");
            }

            //4. nhớ gọi lại load_data() để load dữ liệu mới lên jtable
            load();
        } catch (Exception e) {
        }
    }
    
    public void delete() {
        try {
            PhieuKhamBenhDAO dao = new PhieuKhamBenhDAO();
            int kq = dao.delete(txtSoPhieuKhamBenh.getText());
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại.");
            }
            load();
        } catch (Exception e) {
           
            e.printStackTrace();
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

        txt_maBS4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoPhieuKhamBenh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboMaHS = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenBenh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_table = new javax.swing.JTable();
        bntThem = new javax.swing.JButton();
        bntXoa = new javax.swing.JButton();
        bntSua = new javax.swing.JButton();
        bntRemind = new javax.swing.JButton();
        bntNext = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboBacsi = new javax.swing.JComboBox();
        txtDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        txt_maBS4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Mã bác sĩ:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH PHIẾU KHÁM BỆNH ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Số phiếu khám bệnh:");

        txtSoPhieuKhamBenh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã hồ sơ:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 3)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Giờ");
        jLabel7.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tên bệnh:");

        txtTenBenh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbl_table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Hoá Đơn Viện Phí", "Số Tiền Viện Phí", "Ngày Đóng Viện Phí", "Mã Hồ Sơ"
            }
        ));
        tbl_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_table);

        bntThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_new_26px_1.png"))); // NOI18N
        bntThem.setText("Thêm");
        bntThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntThemActionPerformed(evt);
            }
        });

        bntXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_26px_1.png"))); // NOI18N
        bntXoa.setText("Xoá");
        bntXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntXoaActionPerformed(evt);
            }
        });

        bntSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_26px.png"))); // NOI18N
        bntSua.setText("Sửa");
        bntSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSuaActionPerformed(evt);
            }
        });

        bntRemind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_rewind_26px.png"))); // NOI18N
        bntRemind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRemindActionPerformed(evt);
            }
        });

        bntNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_fast_forward_26px.png"))); // NOI18N
        bntNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mã bác sĩ:");

        txtDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Ngày khám bệnh:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(bntThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntXoa)
                .addGap(18, 18, 18)
                .addComponent(bntSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntRemind)
                .addGap(18, 18, 18)
                .addComponent(bntNext)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenBenh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoPhieuKhamBenh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboMaHS, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboBacsi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cboBacsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cboMaHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSoPhieuKhamBenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenBenh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntThem)
                    .addComponent(bntXoa)
                    .addComponent(bntSua)
                    .addComponent(bntRemind)
                    .addComponent(bntNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tableMouseClicked
        // TODO add your handling code here:
        try {
            current = tbl_table.getSelectedRow();
        show_Detail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_tableMouseClicked

    private void bntRemindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRemindActionPerformed
        // TODO add your handling code here:
        try {
            current -= 1;
            if(current < 0){
                 current = list.size();
            }
         show_Detail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bntRemindActionPerformed

    private void bntNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextActionPerformed
        // TODO add your handling code here:
        try {
            current += 1;
            if(current > list.size()){
                 current = 0;
            }
         show_Detail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bntNextActionPerformed

    private void bntThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_bntThemActionPerformed

    private void bntXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_bntXoaActionPerformed

    private void bntSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_bntSuaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_qlPhieuKhamBenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_qlPhieuKhamBenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_qlPhieuKhamBenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_qlPhieuKhamBenh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_qlPhieuKhamBenh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNext;
    private javax.swing.JButton bntRemind;
    private javax.swing.JButton bntSua;
    private javax.swing.JButton bntThem;
    private javax.swing.JButton bntXoa;
    private javax.swing.JComboBox cboBacsi;
    private javax.swing.JComboBox cboMaHS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_table;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtSoPhieuKhamBenh;
    private javax.swing.JTextField txtTenBenh;
    private javax.swing.JTextField txt_maBS4;
    // End of variables declaration//GEN-END:variables
}
