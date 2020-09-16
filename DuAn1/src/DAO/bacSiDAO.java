/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import connect.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.bacSi;
/**
 *
 * @author Quang
 */
public class bacSiDAO {
   public int insertBS(bacSi bs) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into BacSi values(?,?,?,?,?,?,?)");
                //1. Truyền giá trị  vào đối số 
                ps.setString(1, bs.getMaBacSi());
                ps.setString(2, bs.getMaKhoa());
                ps.setString(3, bs.getTenBacSi());
                ps.setString(4, bs.getNgaySinh());
                ps.setString(5, bs.getDiaChi());
                ps.setString(6, bs.getDienThoai());
                ps.setString(7, bs.getAnhBacSi());
                
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
   public int deleteBS(String MaBacSi){
        int kq = 0; 
        Connection cn = new MyConnect().getcn();
        //1. Nếu cn khác null - kết nối database được
        if (cn != null){
            try {
                PreparedStatement ps = cn.prepareStatement("delete from BacSi where MaBacSi=? ");
                ps.setString(1, MaBacSi);
                kq = ps.executeUpdate(); // xóa thành công 1 dòng thì kq = 1 ...kq =0 không xóa được dòng nào
                ps.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return kq;
    }
   public int UPdateBS(bacSi bs) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("update BacSi set MaKhoa=?, TenBacSi=?, NgaySinh=?, DiaChi=?, DienThoai=?, AnhBacSi=? where MaBacSi=?");
                //1. Truyền giá trị  vào đối số 
               
                ps.setString(1, bs.getMaKhoa());
                ps.setString(2, bs.getTenBacSi());
                ps.setString(3, bs.getNgaySinh());
                ps.setString(4, bs.getDiaChi());
                ps.setString(5, bs.getDienThoai());
                ps.setString(6, bs.getAnhBacSi());
                ps.setString(7, bs.getMaBacSi());
                
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
}
