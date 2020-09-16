/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DAO.HoSoBenhAnDAO;
import DAO.bacSiDAO;
import DAO.nguoiDungDAO;
import connect.MyConnect;
import helper.ShareHelper;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoSoBenhAn;


/**
 *
 * @author Quang
 */
public class Frm_qlHoSoBenhAn extends javax.swing.JFrame {
 ArrayList<HoSoBenhAn> list = new ArrayList<>();
   int current = 0;
   private final Date today = new Date();
    Locale local = new Locale("vi", "VI");
    DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
    String date = d.format(today);
    /**
     * Creates new form frm_qlUser
     */
    public Frm_qlHoSoBenhAn() {
        initComponents();
        txt_ngayLapHS.setText(date);
        txt_ngayLapHS.setEnabled(false);
        load();
        comboBox();
    }
    public void load(){
        try {
             
            Connection cn = new MyConnect().getcn();
            PreparedStatement ps = cn.prepareStatement("select * from HoSoBenhAn");
             ResultSet rs = ps.executeQuery();
            list.clear();// xoá list để lấy dữ liệu từ bảng
            while(rs.next()){
                HoSoBenhAn hs = new HoSoBenhAn(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(hs);
            }
            cn.close();
            ps.close();
            DefaultTableModel model = (DefaultTableModel) tbl_table.getModel();
        model.setRowCount(0);
        for(HoSoBenhAn hs: list){
            Object[] row = new Object[]{hs.getMaHoSo(),hs.getHoTen(),hs.isGioiTinh()? "Nam" : "Nữ",hs.getNgaySinh(),hs.getDiaChi(),hs.getDienThoai(),hs.getNgayLapHS(),hs.getNgayHetHanHS(),hs.getMaNhanVien()};
            model.addRow(row);
        }
        } catch (Exception e) {
        }
    }
    public void show_Detail(){
        // lấy ra sv hiện hành
        HoSoBenhAn hs = list.get(current);
        // gán thông tin sv lên form
        txt_maHoSo.setText(hs.getMaHoSo());
        txt_hoTen.setText(hs.getHoTen());
        if(hs.isGioiTinh() == true){
            rdo_nam.setSelected(true);
        }else {
             rdo_nu.setSelected(true);
        }
        txt_ngaySinh.setText(hs.getNgaySinh());
        txt_diaChi.setText(hs.getDiaChi());
        txt_dienThoai.setText(hs.getDienThoai());
        txt_ngayLapHS.setText(hs.getNgayLapHS());
        txt_ngayHetHanHS.setText(hs.getNgayHetHanHS());
        jComboBox1.setSelectedItem(hs.getMaNhanVien());
       
    }
    public void insert(){
        try {
            HoSoBenhAn hs = new HoSoBenhAn();
        hs.setMaHoSo(txt_maHoSo.getText());
        hs.setHoTen(txt_hoTen.getText());
        if (rdo_nam.isSelected() == true) {
                hs.setGioiTinh(true);
            } else {
                hs.setGioiTinh(false);
            }
        hs.setNgaySinh(txt_ngaySinh.getText());
        hs.setDiaChi(txt_diaChi.getText());
        hs.setDienThoai(txt_dienThoai.getText());
        hs.setNgayLapHS(txt_ngayLapHS.getText());
        hs.setNgayHetHanHS(txt_ngayHetHanHS.getText());
        hs.setMaNhanVien(jComboBox1.getSelectedItem().toString());
        HoSoBenhAnDAO dao = new HoSoBenhAnDAO();
           
            int kq = dao.insertHS(hs);
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Thêm thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại.");
            }

            //4. nhớ gọi lại load_data() để load dữ liệu mới lên jtable
            load();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Thêm Không Thành Công.");
            e.printStackTrace();
        }
    }
    public void update(){
        try {
            HoSoBenhAn hs = new HoSoBenhAn();
        hs.setMaHoSo(txt_maHoSo.getText());
        hs.setHoTen(txt_hoTen.getText());
        if (rdo_nam.isSelected() == true) {
                hs.setGioiTinh(true);
            } else {
                hs.setGioiTinh(false);
            }
        hs.setNgaySinh(txt_ngaySinh.getText());
        hs.setDiaChi(txt_diaChi.getText());
        hs.setDienThoai(txt_dienThoai.getText());
        hs.setNgayLapHS(txt_ngayLapHS.getText());
        hs.setNgayHetHanHS(txt_ngayHetHanHS.getText());
        hs.setMaNhanVien(jComboBox1.getSelectedItem().toString());
        HoSoBenhAnDAO dao = new HoSoBenhAnDAO();
           
            int kq = dao.UpdatetHS(hs);
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Sửa thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại.");
            }

            //4. nhớ gọi lại load_data() để load dữ liệu mới lên jtable
            load();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Sửa Không Thành Công.");
            e.printStackTrace();
        }
    }
     public void delete() {
        try {
            HoSoBenhAnDAO dao = new HoSoBenhAnDAO();
            int kq = dao.deleteHS(txt_maHoSo.getText());
            if (kq == 1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại.");
            }
            load();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa Không Thành Công.");
            e.printStackTrace();
        }
    }
    public void comboBox(){
        jComboBox1.addItem("NV001");
        jComboBox1.addItem("NV002");
        jComboBox1.addItem("NV003");
        jComboBox1.addItem("NV004");
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_table = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_rewind = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_maHoSo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_diaChi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_dienThoai = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_ngayHetHanHS = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_ngayLapHS = new javax.swing.JTextField();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        btn_reset = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        txt_maBS4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Mã bác sĩ:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH HỒ SƠ BỆNH ÁN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 33, 89)));

        tbl_table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hồ Sơ", "Họ Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Điện Thoại", "Ngày Lập Hồ Sơ", "Ngày Hết Hạn Hồ Sơ", "Mã Nhân Viên"
            }
        ));
        tbl_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_new_26px_1.png"))); // NOI18N
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_26px_1.png"))); // NOI18N
        btn_delete.setText("Xoá");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_26px.png"))); // NOI18N
        btn_edit.setText("Sửa");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_fast_forward_26px.png"))); // NOI18N
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_rewind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_rewind_26px.png"))); // NOI18N
        btn_rewind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rewindActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Mã hồ sơ:");

        txt_maHoSo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Họ tên:");

        txt_hoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Giới tính:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Ngày sinh:");

        txt_ngaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Địa chỉ:");

        txt_diaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Điện thoại:");

        txt_dienThoai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Mã nhân viên:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Ngày hết hạn hồ sơ:");

        txt_ngayHetHanHS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Ngày lập hồ sơ:");

        txt_ngayLapHS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        buttonGroup1.add(rdo_nam);
        rdo_nam.setText("Nam");

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("Nữ");

        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_26px.png"))); // NOI18N
        btn_reset.setText("Nhập lại");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdo_nam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdo_nu))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_maHoSo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_dienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btn_rewind)
                                            .addGap(18, 18, 18)
                                            .addComponent(btn_next))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_ngayHetHanHS, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                .addComponent(txt_ngayLapHS, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btn_add)
                                .addGap(28, 28, 28)
                                .addComponent(btn_delete)
                                .addGap(18, 18, 18)
                                .addComponent(btn_edit)
                                .addGap(18, 18, 18)
                                .addComponent(btn_reset)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_maHoSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_dienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txt_ngayLapHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txt_ngayHetHanHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(rdo_nam)
                            .addComponent(rdo_nu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_add)
                                .addComponent(btn_delete)
                                .addComponent(btn_edit)
                                .addComponent(btn_reset))
                            .addComponent(btn_rewind, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_next))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void btn_rewindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rewindActionPerformed
        // TODO add your handling code here:
       try {
            current -= 1;
            if(current < 0){
                 current = list.size();
            }
         show_Detail();
        } catch (Exception e) {
        }
       
    }//GEN-LAST:event_btn_rewindActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // TODO add your handling code here:
        try {
            current += 1;
            if(current > list.size()){
                 current = 0;
            }
         show_Detail();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        txt_maHoSo.setText("");
        txt_hoTen.setText("");
        txt_ngaySinh.setText("");
        txt_diaChi.setText("");
        txt_dienThoai.setText("");
        
        txt_ngayHetHanHS.setText("");
       
    }//GEN-LAST:event_btn_resetActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_qlHoSoBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_qlHoSoBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_qlHoSoBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_qlHoSoBenhAn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Frm_qlHoSoBenhAn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_rewind;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTable tbl_table;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_dienThoai;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maBS4;
    private javax.swing.JTextField txt_maHoSo;
    private javax.swing.JTextField txt_ngayHetHanHS;
    private javax.swing.JTextField txt_ngayLapHS;
    private javax.swing.JTextField txt_ngaySinh;
    // End of variables declaration//GEN-END:variables
}
