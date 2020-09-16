/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.phieuKhamBenh;

/**
 *
 * @author Quang
 */
public class PhieuKhamBenhDAO {
    public int insert(phieuKhamBenh pkb) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into PhieuKhamBenh values(?,?,?,?,?)");
                //1. Truyền giá trị  vào đối số 
                ps.setString(1, pkb.getSoPhieuKhamBenh());
                ps.setString(2, pkb.getMaHoSo());
                ps.setString(3, pkb.getMaBacSi());
                ps.setString(4, pkb.getTenBenh());
                ps.setString(5, pkb.getNgayKhamBenh());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
    public int update(phieuKhamBenh pkb) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("update PhieuKhamBenh set MaHoSo=?, MaBacSi=?, TenBenh=?, NgayKhamBenh=? where SoPhieuKhamBenh=?");
                //1. Truyền giá trị  vào đối số 
                
                ps.setString(1, pkb.getMaHoSo());
                ps.setString(2, pkb.getMaBacSi());
                ps.setString(3, pkb.getTenBenh());
                ps.setString(4, pkb.getNgayKhamBenh());
                ps.setString(5, pkb.getSoPhieuKhamBenh());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
    public int delete(String SoPhieuKhamBenh){
        int kq = 0; 
        Connection cn = new MyConnect().getcn();
        //1. Nếu cn khác null - kết nối database được
        if (cn != null){
            try {
                PreparedStatement ps = cn.prepareStatement("delete from PhieuKhamBenh where SoPhieuKhamBenh=? ");
                ps.setString(1, SoPhieuKhamBenh);
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
