/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.HoSoBenhAn;
/**
 *
 * @author Quang
 */
public class HoSoBenhAnDAO {
    public int insertHS(HoSoBenhAn hs) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into HoSoBenhAn values(?,?,?,?,?,?,?,?,?)");
                //1. Truyền giá trị  vào đối số 
                ps.setString(1, hs.getMaHoSo());
                ps.setString(2, hs.getHoTen());
                ps.setBoolean(3, hs.isGioiTinh());
                ps.setString(4, hs.getNgaySinh());
                ps.setString(5, hs.getDiaChi());
                ps.setString(6, hs.getDienThoai());
                ps.setString(7, hs.getNgayLapHS());
                ps.setString(8, hs.getNgayHetHanHS());
                ps.setString(9, hs.getMaNhanVien());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
     public int UpdatetHS(HoSoBenhAn hs) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("update HoSoBenhAn set HoTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?, DienThoai=?, NgayLapHoSo=?, NgayHetHanHoSo=?, MaNhanVien=? where MaHoSo=?");
                //1. Truyền giá trị  vào đối số 
                
                ps.setString(1, hs.getHoTen());
                ps.setBoolean(2, hs.isGioiTinh());
                ps.setString(3, hs.getNgaySinh());
                ps.setString(4, hs.getDiaChi());
                ps.setString(5, hs.getDienThoai());
                ps.setString(6, hs.getNgayLapHS());
                ps.setString(7, hs.getNgayHetHanHS());
                ps.setString(8, hs.getMaNhanVien());
                ps.setString(9, hs.getMaHoSo());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
     public int deleteHS(String MaHoSo){
        int kq = 0; 
        Connection cn = new MyConnect().getcn();
        //1. Nếu cn khác null - kết nối database được
        if (cn != null){
            try {
                PreparedStatement ps = cn.prepareStatement("delete from HoSoBenhAn where MaHoSo=? ");
                ps.setString(1, MaHoSo);
                kq = ps.executeUpdate(); // xóa thành công 1 dòng thì kq = 1 ...kq =0 không xóa được dòng nào
                ps.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return kq;
    }
}
