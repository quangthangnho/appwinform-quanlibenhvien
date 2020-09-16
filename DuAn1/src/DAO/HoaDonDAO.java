/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.HoaDonVienPhi;

/**
 *
 * @author Quang
 */
public class HoaDonDAO {
    public int insertHD(HoaDonVienPhi hd) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into VienPhi values(?,?,?,?)");
                //1. Truyền giá trị  vào đối số 
                ps.setString(1, hd.getMaHoaDonVP());
                ps.setString(2, hd.getTienVP());
                ps.setString(3, hd.getNgayDongVP());
                ps.setString(4, hd.getMaHS());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
    public int updateHD(HoaDonVienPhi hd) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("update VienPhi set SoTienVienPhi=?, NgayDongVienPhi=?, MaHoSo=? where MaHoaDonVienPhi=?");
                //1. Truyền giá trị  vào đối số 
                
                ps.setString(1, hd.getTienVP());
                ps.setString(2, hd.getNgayDongVP());
                ps.setString(3, hd.getMaHS());
                ps.setString(4, hd.getMaHoaDonVP());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
    public int deleteHD(String MaHoaDonVienPhi){
        int kq = 0; 
        Connection cn = new MyConnect().getcn();
        //1. Nếu cn khác null - kết nối database được
        if (cn != null){
            try {
                PreparedStatement ps = cn.prepareStatement("delete from VienPhi where MaHoaDonVienPhi=? ");
                ps.setString(1, MaHoaDonVienPhi);
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
