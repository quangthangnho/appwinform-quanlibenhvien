/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.nguoiDung;

/**
 *
 * @author Quang
 */
public class nguoiDungDAO {
    public int insertND(nguoiDung nd) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into NguoiDung values(?,?,?)");
                //1. Truyền giá trị  vào đối số 
                ps.setString(1, nd.getTenDangNhap());
                ps.setString(2, nd.getMatKhau());
                ps.setString(3, nd.getVaiTro());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
    public int deleteND(String tenDangNhap)
    {
        int kq = 0;
        
        Connection cn = new MyConnect().getcn();
        //1. Nếu cn khác null - kết nối database được
        if (cn != null)
        {
            try {
                PreparedStatement ps = cn.prepareStatement("delete from NguoiDung where TenDangNhap=? ");
                ps.setString(1, tenDangNhap);
                kq = ps.executeUpdate(); // xóa thành công 1 dòng thì kq = 1 ...kq =0 không xóa được dòng nào
                ps.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return kq;
    }
    
    
    //4. Hàm updateStudent(Student stu)
    // kq = 1 : sửa thành công
    // kq = 0 : sửa thất bại
    public int updateND(nguoiDung nd) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("update NguoiDung set MatKhau=?, VaiTro=?  where TenDangNhap=?");
                //1. Truyền giá trị  vào đối số 
                ps.setString(1, nd.getMatKhau());
                ps.setString(2, nd.getVaiTro());
                ps.setString(3, nd.getTenDangNhap());
                kq = ps.executeUpdate();
                ps.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
}
