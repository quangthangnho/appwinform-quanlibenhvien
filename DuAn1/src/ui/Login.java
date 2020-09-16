/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import AppPackage.AnimationClass;
import connect.MyConnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Quang
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }
    void dangNhap(){
        try {
             Connection cn = new MyConnect().getcn();
            // tạo dối tuongwj thi hành câu lệnh sql
            PreparedStatement ps = cn.prepareStatement("select * from NguoiDung where TenDangNhap=? and MatKhau=?");
            ps.setString(1, txt_username.getText());
            ps.setString(2, txt_password.getText());
            // thi hành câu lệnh sql
            ResultSet rs = ps.executeQuery();
            // nếu username và pass đúng tjif rs sẽ có 1 dòng
            // rs.next() là true
            if(rs.next()){
                this.dispose();
                Frm_admin giaoDien = new Frm_admin();
                giaoDien.setVisible(true);
            }else{
                // chuiwr đangw nhập thất bại
                JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu");
                txt_username.requestFocus();
                return;
            }
            ps.close();
            cn.close();
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

        jPanel1 = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        lbl_iconTK = new javax.swing.JLabel();
        lbl_iconMK = new javax.swing.JLabel();
        lbl_menu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();
        lbl_expandRow = new javax.swing.JLabel();
        btn_DangNhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_username.setBackground(new java.awt.Color(54, 33, 89));
        lbl_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(54, 33, 89));
        lbl_username.setText("Tên tài khoản:");
        jPanel1.add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        lbl_password.setBackground(new java.awt.Color(54, 33, 89));
        lbl_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(54, 33, 89));
        lbl_password.setText("Mật khẩu:");
        jPanel1.add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_96px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 100, 120));

        jSeparator1.setBackground(new java.awt.Color(60, 63, 65));
        jSeparator1.setForeground(new java.awt.Color(45, 45, 45));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 210, 10));

        jSeparator2.setBackground(new java.awt.Color(60, 63, 65));
        jSeparator2.setForeground(new java.awt.Color(45, 45, 45));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 210, 10));

        txt_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_username.setForeground(new java.awt.Color(153, 153, 153));
        txt_username.setBorder(null);
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usernameMouseClicked(evt);
            }
        });
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 180, 40));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(153, 153, 153));
        txt_password.setBorder(null);
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_passwordMouseClicked(evt);
            }
        });
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 180, 40));

        lbl_iconTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_32px_1.png"))); // NOI18N
        jPanel1.add(lbl_iconTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lbl_iconMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_key_32px_1.png"))); // NOI18N
        jPanel1.add(lbl_iconMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        lbl_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_32px.png"))); // NOI18N
        lbl_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_menuMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Globe_32px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 50, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Calculator_32px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 90, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Musical_Notes_32px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 130, -1, -1));

        lbl_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Multiply_32px.png"))); // NOI18N
        lbl_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exitMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        lbl_expandRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Expand_Arrow_32px.png"))); // NOI18N
        lbl_expandRow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_expandRowMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_expandRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        btn_DangNhap.setBackground(new java.awt.Color(54, 33, 89));
        btn_DangNhap.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btn_DangNhap.setForeground(new java.awt.Color(54, 33, 89));
        btn_DangNhap.setText("ĐĂNG NHẬP");
        btn_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btn_DangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_menuMouseClicked
        // hiện ra
        AnimationClass internet = new AnimationClass();
        internet.jLabelXRight(-40, 10, 10, 5, jLabel7);
        // 
        AnimationClass internett = new AnimationClass();
        internet.jLabelXRight(-40, 10, 10, 5, jLabel8);
       // 
        AnimationClass internettt = new AnimationClass();
        internet.jLabelXRight(-40, 10, 10, 5, jLabel9);
        // --------------------------- ẩn vào
        AnimationClass inter = new AnimationClass();
        internet.jLabelXLeft(10, -40, 10, 5, jLabel7);
        // 
        AnimationClass interr = new AnimationClass();
        internet.jLabelXLeft(10, -40, 10, 5, jLabel8);
       // 
        AnimationClass interrr = new AnimationClass();
        internet.jLabelXLeft(10, -40, 10, 5, jLabel9);
    }//GEN-LAST:event_lbl_menuMouseClicked

    private void lbl_expandRowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_expandRowMouseClicked
        // TODO add your handling code here:
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_lbl_expandRowMouseClicked

    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?","Thoát",dialog);
        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_lbl_exitMouseClicked

    private void btn_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangNhapActionPerformed

        if (txt_username.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(this, "Không để trống tên đăng nhập!");
           
            
            return; // kết thúc hàm ko kiểm tra các lệnh phía dưới.
        }
        if (txt_password.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(this, "Không để trống mật khẩu!");
            
            
            return; // kết thúc hàm ko kiểm tra các lệnh phía dưới.
        }
        dangNhap();
        
        
    }//GEN-LAST:event_btn_DangNhapActionPerformed

    private void txt_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txt_usernameMouseClicked

    private void txt_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txt_passwordMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangNhap;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_expandRow;
    private javax.swing.JLabel lbl_iconMK;
    private javax.swing.JLabel lbl_iconTK;
    private javax.swing.JLabel lbl_menu;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
