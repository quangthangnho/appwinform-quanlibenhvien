/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connect.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.ToaThuoc;

/**
 *
 * @author Quang
 */
public class ToaThuocDAO {
    public int insert(ToaThuoc thuoc) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into ToaThuoc values(?,?,?)");
                //1. Truyền giá trị  vào đối số 
                ps.setString(1, thuoc.getSoPhieuKhamBenh());
                ps.setString(2, thuoc.getMaThuoc());
                ps.setString(3, thuoc.getCachSuDung());
                kq = ps.executeUpdate();
            //ps.close();
                //cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }
    public int update(ToaThuoc thuoc) {
        int kq = 0;
        Connection cn = new MyConnect().getcn();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("update ToaThuoc set MaThuoc=?, CachSuDung=? where SoPhieuKhamBenh=?");
                //1. Truyền giá trị  vào đối số 
                
                ps.setString(1, thuoc.getMaThuoc());
                ps.setString(2, thuoc.getCachSuDung());
                ps.setString(3, thuoc.getSoPhieuKhamBenh());
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
                PreparedStatement ps = cn.prepareStatement("delete from ToaThuoc where SoPhieuKhamBenh=? ");
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
